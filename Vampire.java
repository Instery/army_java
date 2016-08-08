public class Vampire extends Unit {
    public Vampire(String name, int aHitPoints, int aDamage) {
        super(name, aHitPoints, aDamage);
        this.isUndead = true;
        this.currentState = new VampireState(name, hitPoints, damage);
        this.attack = this.currentState.attack;
    }
    public Vampire() {
        this("Vampire", 110, 15);
    }
    
    protected void lifeLeech(Unit victim, Unit self) throws UnitException {
        this.addHitPoints(victim.hitPointsLimit/10);
        System.out.println(name+ " life leech " + victim.getName() + " for " + victim.hitPointsLimit/10);
    }
    
    public void attack(Unit enemy) throws UnitException {
        // enemy.ensureIsAlive();
        // this.lifeLeech(enemy, this);
        // enemy.takeDamage(damage);
        attack.attack(enemy);
        enemy.counterAttack(this);
    }
    
    public void counterAttack(Unit enemy) throws UnitException {
        // this.lifeLeech(enemy, this);
        // enemy.takeDamage(damage/2);
        attack.counterAttack(enemy);
    }
}
