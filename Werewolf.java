public class Werewolf extends Unit {
    public Werewolf(String name, int aHitPoints, int aDamage) {
        super(name, aHitPoints, aDamage);
        this.isWolf = true;
        this.currentState = new NormalState(name, hitPoints, damage);
        this.name = currentState.getName();
        this.hitPoints = currentState.getHitPoints();
        this.hitPointsLimit = currentState.getHitPointsLimit();
        this.damage = currentState.getDamage();
        this.alterState = new WolfState(name, hitPoints, damage);
        // this.attack = new WerewolfAttack(this.name, this.hitPoints, this.damage);
        this.attack = currentState.attack;
    }
    public void attack(Unit enemy) throws UnitException {
        enemy.ensureIsAlive();
        attack.attack(enemy);
        enemy.counterAttack(this);
    }
    public void counterAttack(Unit enemy) throws UnitException {
        enemy.ensureIsAlive();
        attack.takeDamage(damage);
    }
    public void takeMagicDamage(int dmg, Unit target) throws UnitException {
        currentState.takeMagicDamage(dmg, this);
        System.out.println(dmg);
    }
    public void takeDamage(int dmg) throws UnitException {
        ensureIsAlive();
        
        if ( this.hitPoints < dmg ) {
            this.hitPoints = 0;
        }
        this.hitPoints -= dmg;
    }
}
