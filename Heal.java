public class Heal extends Spell {
    public Heal() {
        this.spellName = "HEAL";
    }
    public void action(Unit self, Unit target) throws UnitException {
        int healPoints = actionPoints;
        
        if ( self.getIsBattleMage() == true ) {
            healPoints /= 2;
        }
        target.addHitPoints(healPoints);
    }
}
