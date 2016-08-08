public class Warlock extends SpellCaster {
    private Demon slave;

    public Warlock(String name, int hp, int dmg, int mana) {
        super(name, hp, dmg, mana);
        this.isBattleMage = true;
        this.spellBook = new SpellBook();
        this.spellBook.addSpell("FIREBALL", new FireBall());
        this.spellBook.addSpell("HEAL", new Heal());
        this.slave = null;
        this.attack = new DefaultAttack(this.name, this.hitPoints, this.damage);
    }

    public void summon() {
        if ( slave == null ) {
            slave = new Demon(this);
        }
    }

    public void free() {
        if ( slave != null ) {
            slave = null;
        }
    }

    public Demon demon() {
        return slave;
    }
}
