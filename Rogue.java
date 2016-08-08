public class Rogue extends Unit {
    public Rogue(String name, int aHitPoints, int aDamage) {
        super(name, aHitPoints, aDamage);
        this.attack = new DefaultAttack(this.name, this.hitPoints, this.damage);
    }
    public Rogue(){
        this("Rogue", 100, 35);
        this.attack = new DefaultAttack(this.name, this.hitPoints, this.damage);
    }
    
    public void attack(Unit enemy) throws UnitException {
        enemy.ensureIsAlive();
        enemy.takeDamage(this.damage);
    }
}
