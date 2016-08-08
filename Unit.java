import java.util.HashSet;
import java.util.Iterator;

public abstract class Unit {
    protected boolean isBattleMage;
    protected boolean isHealerMage;
    protected boolean isWolf;
    protected boolean isUndead;
    protected int damage;
    protected int hitPoints;
    protected int hitPointsLimit;
    protected String name;
    protected State currentState;
    protected State alterState;
    protected AttackMethod attack;
    protected HashSet<Unit> observers;
    
    
    public Unit(String name, int aHitPoints, int aDamage) {
        this.damage = aDamage;
        this.hitPoints = aHitPoints;
        this.hitPointsLimit = aHitPoints;
        this.name = name;
        this.isWolf = false;
        this.observers = new HashSet<Unit>();
    }
    
    public boolean getIsBattleMage() {
        return this.isBattleMage;
    }
    public boolean getIsHealerMage() {
        return this.isHealerMage;
    }
    public int getDamage(){
        return this.damage;
    }
    public int getHitPoints() {
        return this.hitPoints;
    }
    public int getHitPointsLimit() {
        return this.hitPointsLimit;
    }
    public String getName() {
        return this.name;
    }
    public State getState() {
        return this.currentState;
    }
    public AttackMethod getAttackMethod() {
        return this.attack;
    }
    public boolean getIsWolf() {
        return this.isWolf;
    }
    public boolean getIsUndead() {
        return this.isUndead;
    }
    
    protected void ensureIsAlive() throws UnitException {
        if ( this.hitPoints == 0 ) {
            throw new DeadUnitException();
        }
    }
    
    public boolean setIsWolf() {
        return this.isWolf = true;
    }
    public boolean setIsUndead() {
        return this.isUndead = true;
    }
    
    public void addHitPoints(int hp) throws UnitException {
        ensureIsAlive();
        int total = this.hitPoints + hp;
        
        if ( total > this.hitPointsLimit ) {
            this.hitPoints = this.hitPointsLimit;
            return;
        }
        this.hitPoints += hp;
    }
    
    public void takeDamage(int dmg) throws UnitException {
        ensureIsAlive();
        
        if ( this.hitPoints < dmg ) {
            this.hitPoints = 0;
            sendNotifications();
            return;
        }
        this.hitPoints -= dmg;
    }
    
    public void takeMagicDamage(int dmg, Unit target) throws UnitException {
        this.takeDamage(dmg);
    }
    
    public void attack(Unit enemy) throws UnitException {
        ensureIsAlive();
        attack.attack(enemy);
        enemy.counterAttack(this);
    }
    
    
    public void counterAttack(Unit enemy) throws UnitException {
        enemy.takeDamage(damage/2);
    }
    
    public void changeState() throws UnitException {
        State tempState = this.currentState;
        this.attack = alterState.getAttackMethod();
        this.name = alterState.getName();
        double coef = (double)this.hitPoints / (double)this.hitPointsLimit;
      
        this.hitPoints = (int)((double)alterState.hitPointsLimit * coef);
        this.hitPointsLimit = alterState.getHitPointsLimit();
        this.damage = alterState.getDamage();
        
        this.currentState = alterState;
        this.alterState = tempState;
        // this.hitPoints = currentState.getHitPointsLimit();
        
        // System.out.println((double)alterState.getHitPoints());
        // System.out.println((double)alterState.getHitPointsLimit());
        
    }
    public void addObserver(Unit observer) {
        observers.add(observer);
    }

    public void removeObserver(Unit observer) {
        observers.remove(observer);
    }

    public void sendNotifications() throws UnitException {
        Iterator iter = observers.iterator();
        while (iter.hasNext()) {
            Necromancer n = ((Necromancer)iter.next());
            n.addHitPoints(hitPointsLimit/10);
            n.removeVictim(this);
        }
    }
    
    public String toString() {
        StringBuffer out = new StringBuffer(name+": ");

        out.append("hp[" + hitPoints + "/" + hitPointsLimit + "]");
        out.append(", dmg[" + damage + "]");
        return out.toString();
    }
}
