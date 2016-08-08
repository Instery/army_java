public class WolfState extends State {
    public WolfState(String aName, int aHitPoints, int aDamage) {
        super(aName + "(wolf)", aHitPoints + 75, aDamage + 30);
        this.attack = new WerewolfAttack(this.name, this.hitPoints, this.damage);
    }
    // public void attack(Unit enemy) throws UnitException {
    //     if ( enemy.getIsWolf() == false ) {
    //         enemy.setIsWolf();
    //     }
    //         System.out.println("WOW! WOLF!!");
    //     enemy.ensureIsAlive();
    //     enemy.takeDamage(this.damage);
    // }
    public void takeMagicDamage(int dmg, Unit target) throws UnitException {
        System.out.println(dmg);
        target.takeDamage(dmg*2);
        System.out.println("AGRRRHH!!");
    }
}
