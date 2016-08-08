public class Berserker extends Unit {
    public Berserker(String name, int aHitPoints, int aDamage) {
        super(name, aHitPoints, aDamage);
        this.attack = new DefaultAttack(this.name, this.hitPoints, this.damage);
    }
    public Berserker() {
        this("Berserker", 200, 25);
        this.attack = new DefaultAttack(this.name, this.hitPoints, this.damage);
    }
    
    public void takeMagicDamage() {
        System.out.println(name + " resisted any harmless magic");
    }
}
