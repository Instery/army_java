public class Demon extends Soldier {
    private Warlock master;

    public Demon(Warlock master) {
        super("Demon", 150, 20);
        this.master = master;
    }
}
