public abstract class Spell {
    public static int actionPoints = 30;
    protected String spellName;

    public int getCost() {
        return actionPoints;
    }
    public String getName() {
        return this.spellName;
    }

    public abstract void action(Unit self, Unit target) throws UnitException;
}
