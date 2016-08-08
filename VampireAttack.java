public class VampireAttack extends AttackMethod {
    protected VampireState vampire;
    
    public VampireAttack(String aName, int aHitPoints, int aDamage) {
        super(aName, aHitPoints, aDamage);
    }
    public void attack(Unit enemy) throws UnitException {
        enemy.ensureIsAlive();
        if ( (enemy.getIsWolf() == false) && (enemy.getIsUndead() == false) ) {
        System.out.println(enemy.getName() + " is now infected!");
            enemy.setIsUndead();
            enemy.currentState = new VampireState(enemy.name, enemy.hitPoints, enemy.damage);
            enemy.attack = enemy.currentState.attack;
            enemy.name = enemy.currentState.getName();
        }
        if ( enemy.getIsUndead() == false ) {
            vampire.lifeLeech(enemy, this);
        }
        enemy.takeDamage(damage);
        // enemy.counterAttack(this);
    }
    public void counterAttack(Unit enemy) throws UnitException {
        enemy.ensureIsAlive();
        if ( (enemy.getIsWolf() == false) && (enemy.getIsUndead() == false) ) {
            System.out.println(enemy.getName() + " is now infected!");
            enemy.setIsUndead();
            enemy.currentState = new VampireState(enemy.name, enemy.hitPoints, enemy.damage);
            enemy.name = enemy.currentState.getName();
        }
        if ( enemy.getIsUndead() == false ) {
            vampire.lifeLeech(enemy, this);
        }
        enemy.takeDamage(damage/2);
    }
}
