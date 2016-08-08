public class PriestAttack extends AttackMethod {
    public PriestAttack(String aName, int aHitPoints, int aDamage) {
        super(aName, aHitPoints, aDamage);
    }
    public void attack(Unit enemy) throws UnitException {
        ensureIsAlive();
        if ( enemy.getIsUndead() ) {
            enemy.takeDamage(damage*2);
        } else {
            enemy.takeDamage(damage);
        }
    }
    // public void counterAttack(Unit enemy) throws UnitException {
    //     if ( enemy.getIsUndead() ) {
    //         enemy.takeDamage(damage);
    //     } else {
    //         enemy.takeDamage(damage/2);
    //     }
    // }
}
