public class Healer extends SpellCaster {
    public Healer(String name, int hp, int dmg, int mana) {
        super(name, hp, dmg, mana);
        this.isHealerMage = true;
        this.spellBook = new SpellBook();
        // System.out.println(spellBook.size());
        this.spellBook.addSpell("FIREBALL", new FireBall());
        this.spellBook.addSpell("HEAL", new Heal());
    }
}
