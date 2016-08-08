public class Wizard extends SpellCaster {
    public Wizard(String name, int hp, int dmg, int mana) {
        super(name, hp, dmg, mana);
        this.isBattleMage = true;
        this.spellBook = new SpellBook();
        // System.out.println(spellBook.size());
        this.attack = new DefaultAttack(this.name, this.hitPoints, this.damage);
        this.spellBook.addSpell("FIREBALL", new FireBall());
        this.spellBook.addSpell("HEAL", new Heal());
    }

}
