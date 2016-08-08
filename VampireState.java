public class VampireState extends State {
    public VampireState(String aName, int aHitPoints, int aDamage) {
        super(aName + "(vampire)", aHitPoints, aDamage );
        this.attack = new VampireAttack(this.name, this.hitPoints, this.damage);
    }
    // public void attack(Unit enemy) throws UnitException {
    //     if ( enemy.getIsWolf() == false ) {
    //         enemy.setIsWolf();
    //     }
    //         System.out.println("WOW! WOLF!!");
    //     enemy.ensureIsAlive();
    //     enemy.takeDamage(this.damage);
    // }
    protected void lifeLeech(Unit victim, Unit self) throws UnitException {
        self.addHitPoints(victim.hitPointsLimit/10);
        System.out.println(name+ " life leech " + victim.getName() + " for " + victim.hitPointsLimit/10);
    }
}
