public class Soldier extends Unit {
    public Soldier(String name, int aHitPoints, int aDamage) {
        super(name, aHitPoints, aDamage);
        this.attack = new DefaultAttack(this.name, this.hitPoints, this.damage);
    }
    public Soldier() {
        this("Soldier", 150, 25);
    }
}
