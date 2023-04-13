import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents the Humans Pokemon.
 * It has a name , health, type and list of attacks.
 */

public class HumansPokemon extends Pokemon {
    /**
     * Constructs a new Pokemon object with the given name, hp ,type.
     * 
     * @param name       The name of the Pokemon.
     * @param hp         The hp of the attack.
     * @param type       The type of Pokemon.
     * @param attackList The list of attacks for the pokemon.
     */
    HumansPokemon(double hp, String name, String type, ArrayList<Attack> attackList) {
        super(hp, name, type, attackList);

    }

    /**
     * Constructs a default new Pokemon object.
     * 
     */
    public HumansPokemon() {
        super();
        super.name = "Charizard";
        super.type = "fire";
        attackList.add(0, new Attack("flamethrower", 15, "fire", 90));
        attackList.add(1, new Attack("fly", 25, "flying", 60));
        attackList.add(2, new Attack("bite", 15, "dark", 60));
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

        double rand = Math.random() * 10;
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
                            .println(this.attackList.get(attackIndex - 1).getAttackDescription() + " is no effective");
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

    // This is an abstract method that lets the pokemon speak to the player.
    @Override
    public void speak() {
        int len = super.name.length();
        System.out.println(super.name + " " + super.name.substring(0, len / 2));
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
        baseHP = hp;
        currentHP = hp;
    }

    /**
     * This is an method that sets the pokemons hp for battle.
     * 
     * @param hp
     */
    @Override
    public void setCurrentHP(double hp) {
        currentHP = hp;
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
     * This is an method that gets the hashmap of pokemon types.
     * 
     * @return PokeType
     */
    @Override
    public HashMap<String, List<Integer>> getPokeType() {
        return super.getPokeType();
    }

    /**
     * This is an method that sets the pokemons attacks.
     *
     */
    @Override
    public void setAttackList() {

        System.out.println("Tell me their four attacks?: ");
        for (int i = 0; i < 4; i++) {
            System.out.println(i + 1 + ") Enter Attack Name: ");
            String attackName = scanner.nextLine();
            System.out.println("Enter Power points(pp): ");
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
            int pp = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Attack Type: ");
            String attackType = scanner.nextLine();
            System.out.println("Enter the amount of Damage: ");
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
            int damage = scanner.nextInt();
            scanner.nextLine();
            attackList.set(i, new Attack(attackName, pp, attackType, damage));

        }

    }

    /**
     * This is an method that allows the users to replace one or all their
     * attacks.
     * 
     */
    public void changeAttacks() {
        ArrayList<Attack> attacks = this.getAttackList();
        int choice = 0;
        while (choice >= 0) {
            System.out.println("-------------Move Menu--------------");
            System.out.println("Which attack do you want to unlearn?");
            for (int i = 0; i < attacks.size(); i++) {
                System.out.println(i + 1 + " " + attacks.get(i));
            }
            do {
                while (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.print("Invalid input. Please enter a valid integer: ");
                }
                choice = scanner.nextInt();
                if (choice < 1 || choice > 4) {
                    System.out.print("Out of Bounds. Please enter a valid integer: ");
                }
            } while (choice < 1 || choice > 4);
            System.out.println("Enter New Attack Name: ");
            String attackName = scanner.nextLine();
            attackName = scanner.nextLine();
            System.out.println("Enter New Power points(pp): ");
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
            int pp = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter New Attack Type: ");
            String attackType = scanner.nextLine();
            System.out.println("Enter the amount of Damage: ");
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
            int damage = scanner.nextInt();

            attackList.set(choice - 1, new Attack(attackName, pp, attackType, damage));
            System.out.println("Move Menu");
            System.out.println("Which attack do you want to unlearn?");
            for (int i = 0; i < attacks.size(); i++) {
                System.out.println(i + 1 + " " + attacks.get(i));
            }
            System.out.println("Enter -1 to Exit");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
            int cont = scanner.nextInt();
            choice = cont;
        }

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
     * Prints Pokemon Description
     * 
     * @return The pokemons information.
     */
    @Override
    public String toString() {
        return "Name: " + name + "\n" + "HP: " + baseHP + "\n" + "Type: " + type;
    }

    /**
     * This is an abstract method that displays the pokemons attacks and allows the
     * user to chose from their list of attacks.
     * 
     * @return an integer that correpsonses to the indices of the attack
     */
    @Override
    public int AttackMenu() {

        ArrayList<Attack> attacks = this.getAttackList();
        int choice = 0;

        System.out.println("-------------Move Menu--------------");
        for (int i = 0; i < attacks.size(); i++) {
            System.out.println(i + 1 + " " + attacks.get(i));
        }
        do {
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
            choice = scanner.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.print("Out of Bounds. Please enter a valid integer: ");
            }
        } while (choice < 1 || choice > 4);

        while (attacks.get(choice - 1).getCurrentPP() <= 0) {
            System.out.println("Attack has no PP");
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
            choice = scanner.nextInt();
        }
        return choice;

    }

}
