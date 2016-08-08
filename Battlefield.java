public class Battlefield {
    public static void main(String[] args) throws UnitException {
        Soldier s1 = new Soldier("S1", 40, 10);
        Soldier s2 = new Soldier("S2", 40, 10);
        Soldier s3 = new Soldier("S3", 40, 10);
        Berserker b1 = new Berserker();
        Rogue r1 = new Rogue();
        Vampire v1 = new Vampire();
        Werewolf w1 = new Werewolf("Werewolf", 200, 30);
        Wizard wi1 = new Wizard("Wizard", 200, 30, 130);
        Priest p1 = new Priest("Priest", 150, 30, 130);
        Healer h1 = new Healer("Healer", 150, 30, 130);
        Necromancer n1 = new Necromancer("Necr", 150, 30, 130);
        Warlock wa1 = new Warlock("Warlock", 150, 30, 130);
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(b1);
        System.out.println(r1);
        System.out.println(v1);
        System.out.println(w1);
        System.out.println(wi1);
        System.out.println(wa1);
        System.out.println(p1);
        System.out.println(n1);
        System.out.println(h1);
        
        System.out.println("-------------");
        
        System.out.println("-------------");
        
        System.out.println(s1);
        // System.out.println(s2);
        // System.out.println(s3);
        // System.out.println(b1);
        // System.out.println(r1);
        // System.out.println(v1);
        // System.out.println(w1);
        // System.out.println(wi1);
        // System.out.println(wa1);
        // System.out.println(p1);
        // System.out.println(n1);
        // System.out.println(h1);
        
    }
}
