public class NormalState extends State {
    public NormalState(String aName, int aHitPoints, int aDamage) {
        super(aName + "(human)", aHitPoints, aDamage);
        this.attack = new DefaultAttack(name, hitPoints, damage);
    }
}
