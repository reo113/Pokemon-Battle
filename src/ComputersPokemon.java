import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents the Computers Pokemon.
 * It has a name , health, type and list of attacks.
 */
public class ComputersPokemon extends Pokemon {

    /**
     * Constructs a new Computer Pokemon object with the given name, hp ,type.
     * 
     * @param name       The name of the Pokemon.
     * @param hp         The hp of the attack.
     * @param type       The type of Pokemon.
     * @param attackList The list of attacks for the pokemon.
     */
    ComputersPokemon(double hp, String name, String type, ArrayList<Attack> attackList) {
        super(hp, name, type, attackList);

    }

    /**
     * Constructs a default new Computer Pokemon object.
     * 
     */
    public ComputersPokemon() {
        super();
        super.name = "Mew";
        super.type = "psychic";
        attackList.add(0, new Attack("psychic", 15, "psychic", 90));
        attackList.add(1, new Attack("surf", 25, "water", 60));
        attackList.add(2, new Attack("psybeam", 15, "psychic", 60));
        attackList.add(3, new Attack("slash", 25, "normal", 60));
    }

    /**
     * This is an method that attacks an opponent.
     * 
     * @param other       The opponents Pokemon.
     * @param attackIndex the chosen attack to use.
     *
     */
    @Override
    public void attack(Pokemon other, int attackIndex) {

        attackIndex = (int) (Math.floor(Math.random() * 4) + 1);

        if (other.getCurrentHP() <= 0) {
            System.out.println(other.getName() + " is unable to battle");
            return;
        }
        if (this.getCurrentHP() <= 0) {
            System.out.println(this.getName() + " is unable to battle");
            return;
        }
        HashMap<String, List<Integer>> alltypes = this.getPokeType();
        int effectiveLevel = 0;
        if (alltypes.containsKey(this.attackList.get(attackIndex - 1).getAttackType())
                && alltypes.containsKey(other.getType())) {
            List<Integer> thisAttackType = alltypes.get(this.attackList.get(attackIndex - 1).getAttackType());
            int effectiveness = thisAttackType.get(0);
            List<Integer> othersType = alltypes.get(other.getType());
            effectiveLevel = othersType.get(effectiveness + 1);
        }

        double rand = Math.floor(Math.random() * 10);
        if (rand <= 8) {
            double health = other.getCurrentHP();
            int damage = this.attackList.get(attackIndex - 1).getBaseDamage();

            if (effectiveLevel == 0) {
                health -= damage;
            } else if (effectiveLevel == 1) {
                damage *= 2;
                health -= damage;
            } else if (effectiveLevel == 2) {
                damage /= 2;
                health -= damage;
            }
            other.setCurrentHP(health);

            if (health <= 0) {
                System.out.println(
                        this.getName() + " used " + this.attackList.get(attackIndex - 1).getAttackDescription());
                if (effectiveLevel == 1) {
                    System.out.println(
                            this.attackList.get(attackIndex - 1).getAttackDescription() + " is super effective.");
                } else if (effectiveLevel == 2) {
                    System.out.println(
                            this.attackList.get(attackIndex - 1).getAttackDescription() + " is not very effective.");
                } else if (effectiveLevel == 3) {
                    System.out
                            .println(this.attackList.get(attackIndex - 1).getAttackDescription() + " has no effective");
                }
                System.out.println(other.getName() + " fainted.");
                System.out.println(this.getName() + " wins");
                this.attackList.get(attackIndex - 1)
                        .setCurrentPP(this.attackList.get(attackIndex - 1).getCurrentPP() - 1);

            } else {
                System.out.println(
                        this.getName() + " used " + this.attackList.get(attackIndex - 1).getAttackDescription());
                if (effectiveLevel == 1) {
                    System.out.println(
                            this.attackList.get(attackIndex - 1).getAttackDescription() + " is super effective.");
                } else if (effectiveLevel == 2) {
                    System.out.println(
                            this.attackList.get(attackIndex - 1).getAttackDescription() + " is not very effective.");
                } else if (effectiveLevel == 3) {
                    System.out
                            .println(this.attackList.get(attackIndex - 1).getAttackDescription() + " has no effective");
                }
                System.out.println(other.getName() + " health is " + other.getCurrentHP());
                this.attackList.get(attackIndex - 1)
                        .setCurrentPP(this.attackList.get(attackIndex - 1).getCurrentPP() - 1);
            }
        } else {
            System.out.println(this.getName() + " missed.");
        }
    }

    /**
     * This is an method that returns the pokemons hp.
     * 
     * @return baseHP
     */
    @Override
    public double getHP() {
        return baseHP;

    }

    /**
     * This is an method that sets the pokemons base hp and current hp.
     * 
     * @param hp
     */
    @Override
    public void setHP(double hp) {
        this.baseHP = hp;
        currentHP = hp;
    }

    /**
     * This is an method that sets the pokemons hp for battle.
     * 
     * @param hp
     */
    @Override
    public void setCurrentHP(double hp) {
        this.currentHP = hp;
    }

    /**
     * This is an method that gets the pokemons hp for battle.
     * 
     * @return currentHP
     */
    @Override
    public double getCurrentHP() {
        return currentHP;

    }

    /**
     * This is an method that gets the pokemons list of attacks.
     * 
     * @return attackList
     */
    @Override
    public ArrayList<Attack> getAttackList() {
        return attackList;

    }

    /**
     * This is an method that gets the pokemons type.
     * 
     * @return type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * This is an method that sets the pokemons type.
     * 
     * @param type
     */
    @Override
    public void setType(String type) {
        this.type = type.toLowerCase();
    }

    /**
     * This is an method that sets the pokemons name.
     * 
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is an method that gets the pokemons name.
     * 
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * This is an method that sets the pokemons attacks.
     *
     */
    @Override
    public void setAttackList() {
        attackList.add(0, new Attack("Thunder", 25, "electric", 90));
        attackList.add(1, new Attack("Psychic", 25, "psychic", 60));
        attackList.add(2, new Attack("Surf", 15, "water", 80));
        attackList.add(3, new Attack("Slash", 25, "normal", 90));

    }

    /**
     * Prints Pokemon Description
     * 
     * @return The pokemons information.
     */
    @Override
    public String toString() {
        return "Name: " + name + "\n" + "HP: " + baseHP + "\n" + "Type: " + type;
    }

    /**
     * The three methods below are Unimplemented method
     * 
     * @method AttackMenu
     * @method changeAttacks
     * @method speak
     */
    @Override
    public int AttackMenu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'AttackMenu'");
    }

    @Override
    public void changeAttacks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeAttacks'");
    }

    @Override
    public void speak() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'speak'");
    }

}
