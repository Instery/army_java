public class Priest extends SpellCaster {
    public Priest(String aName, int aHitPoints, int aDamage, int aMana) {
        super(aName, aHitPoints, aDamage, aMana);
        this.isHealerMage = true;
        this.spellBook = new SpellBook();
        this.spellBook.addSpell("FIREBALL", new FireBall());
        this.spellBook.addSpell("HEAL", new Heal());
        this.attack = new PriestAttack(name, hitPoints, damage);
    }
    public void attack(Unit enemy) throws UnitException {
        enemy.ensureIsAlive();
        attack.attack(enemy);
        enemy.counterAttack(this);
    }
    // public void counterAttack(Unit enemy) throws UnitException {
    //     attack.takeDamage(damage/2);
    // }
}
