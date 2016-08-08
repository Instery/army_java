public class WerewolfAttack extends AttackMethod {
    public WerewolfAttack(String aName, int aHitPoints, int aDamage) {
        super(aName, aHitPoints, aDamage);
    }
    public void attack(Unit enemy) throws UnitException {
        enemy.ensureIsAlive();
        if ( enemy.getIsWolf() == false ) {
        System.out.println(enemy.getName() + " is now infected!");
            enemy.setIsWolf();
        }
        enemy.currentState = new NormalState(enemy.name, enemy.hitPoints, enemy.damage);
        enemy.alterState = new WolfState(enemy.name, enemy.hitPoints, enemy.damage);
        enemy.name = enemy.currentState.getName();
        enemy.takeDamage(damage);
        enemy.counterAttack(this);
    }
    public void counterAttack(Unit enemy) throws UnitException {
        if ( enemy.getIsWolf() == false ) {
            System.out.println(enemy.getName() + " is now infected!");
            enemy.setIsWolf();
        }
        enemy.takeDamage(damage/2);
    }
}
