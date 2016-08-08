import java.util.HashMap;

public abstract class SpellCaster extends Unit {
    protected int mana;
    protected int manaLimit;
    protected SpellBook spellBook;
    protected Spell spell;
    protected HashMap<String, Spell> mySpells;
    
    
    
    public SpellCaster(String aName, int aHitPoints, int aDamage, int aMana) {
        super(aName, aHitPoints, aDamage);
        this.mana = aMana;
        this.manaLimit = aMana;
    }
    
    
    public int getMana(){
        return this.mana;
    }
    public int getManaLimit(){
        return this.manaLimit;
    }
    public SpellBook getSpellBook(){
        return this.spellBook;
    }
    
    public void addMana(int extra) throws UnitException {
        this.ensureIsAlive();
        int total = this.mana + extra;
        
        if ( total > this.manaLimit ) {
            this.mana = this.manaLimit;
            return;
        }
        this.mana += extra;
    }
    public void spendMana(int cost) throws UnitException {
        if ( cost > this.mana ) {
            throw new OutOfManaException();
        }
        this.mana -= cost;
    }
    
    public void cast(String name, Unit target) throws UnitException {
        target.ensureIsAlive();
        mySpells = spellBook.getSpellBook();
        
        mySpells.get(name).action(this, target);
        this.spendMana(mySpells.get(name).getCost());
        
        // for ( mySpells = spellBook.getSpellBook(); ; ) { 
        //     if ( key = name ) { 
        //         System.out.println("BANG!");
        //     }
        // } 
        
        // this.spendMana(spell.getCost());
        // spell.action(name, target);
    }
    
    public String toString() {
        return super.toString() + ", mana(" + mana + "/" + manaLimit + ")";
    }
}
