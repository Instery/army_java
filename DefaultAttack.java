public class DefaultAttack extends AttackMethod {
    public DefaultAttack(String aName, int aHitPoints, int aDamage) {
        super(aName, aHitPoints, aDamage);
    }
    public void attack(Unit enemy) throws UnitException {
        ensureIsAlive();
        enemy.takeDamage(damage);
        enemy.counterAttack(this);
    }
}
