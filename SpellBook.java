import java.util.HashMap;

public class SpellBook {
    protected HashMap<String, Spell> spells;
    
    public SpellBook(){
        this.spells = new HashMap<String, Spell>();
    };
    
    public void addSpell(String name, Spell newSpell) {
        this.spells.put(name, newSpell);
    }
    public HashMap<String, Spell> getSpellBook() {
        return spells;
    }
}
