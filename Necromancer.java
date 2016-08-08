import java.util.HashSet;

public class Necromancer extends SpellCaster {
    private HashSet<Unit> victims;
    
    public Necromancer(String name, int hp, int dmg, int mana) {
        super(name, hp, dmg, mana);
        this.isBattleMage = true;
        this.spellBook = new SpellBook();
        this.attack = new DefaultAttack(this.name, this.hitPoints, this.damage);
        this.spellBook.addSpell("FIREBALL", new FireBall());
        this.spellBook.addSpell("HEAL", new Heal());
        this.victims = new HashSet<Unit>();
    }
    
    public void addVictim(Unit victim) {
        victims.add(victim);
    }

    public void removeVictim(Unit victim) {
        victims.remove(victim);
    }

    public HashSet<Unit> getVictims() {
        return victims;
    }

    public void cast(String name, Unit target) throws UnitException {
        target.ensureIsAlive();
        
        mySpells = spellBook.getSpellBook();
        
        mySpells.get(name).action(this, target);
        this.spendMana(mySpells.get(name).getCost());
        
        this.addVictim(target);
        target.addObserver(this);
    }

}
