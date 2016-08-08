public class FireBall extends Spell {
    public FireBall() {
        this.spellName = "FIREBALL";
    }
    public void action(Unit self, Unit target) throws UnitException {
        int magicDamage = actionPoints;
        
        if ( self.getIsHealerMage() == true ) {
            magicDamage /= 2;
        }
        target.takeMagicDamage(magicDamage, target);
    }
}
