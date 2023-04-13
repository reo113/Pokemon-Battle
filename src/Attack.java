/**
 * This class represents a Attack.
 * It has a name ,pp, type and amount of damage.
 */
public class Attack {

    /**
     * The name of the attack.
     */
    private String attackDescription;

    /**
     * The pp of the attack.
     */
    private int powerPoint = 0;

    /**
     * The type of the attack.
     */
    private String attackType;
    /**
     * The damage of the attack.
     */
    private int baseDamage = 5;
    /**
     * The pp of the attack during battles.
     */
    private int currentPP = powerPoint;

    /**
     * Constructs a new Attack object with the given name, pp ,type, damage.
     * 
     * @param attackDescription The name of the attack.
     * @param powerPoint        The pp of the attack.
     * @param attackType        The type of the attack.
     * @param baseDamage        The damage of the attack.
     */
    public Attack(String attackDescription, int powerPoint, String attackType, int baseDamage) {
        this.attackDescription = attackDescription;
        this.powerPoint = powerPoint;
        currentPP = powerPoint;
        this.attackType = attackType.toLowerCase();
        this.baseDamage = baseDamage;
    }

    /**
     * @return The name of the attack.
     */
    public String getAttackDescription() {
        return attackDescription;
    }

    /**
     * @return The pp of the attack during battles.
     */
    public int getCurrentPP() {
        return currentPP;
    }

    /**
     * Sets the attacks pp
     * 
     * @param pp
     */
    public void setCurrentPP(int pp) {
        currentPP = pp;
    }

    /**
     * @return The pp of the attack.
     */
    public int getPowerPoint() {
        return powerPoint;
    }

    /**
     * @return The type of the attack.
     */
    public String getAttackType() {
        return attackType;
    }

    /**
     * @return The damage of the attack.
     */
    public int getBaseDamage() {
        return baseDamage;
    }

    /**
     * Prints Attack Description
     * 
     * @return full attack details.
     */
    @Override
    public String toString() {
        return "Name: " + attackDescription.toUpperCase() + " [" + attackType + "] " + "Damage: " + baseDamage + " PP: "
                + currentPP;

    }
}
