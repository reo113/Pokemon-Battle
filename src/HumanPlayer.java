/**
 * This an class that represents the Human Player.
 * It has a pokemon and an item.
 */
public class HumanPlayer extends Player {
/**
     * Constructs a new Player object with the given pokemon and items.
     * 
     * @param pokemon The players pokemon.
     * @param item    The players item
     */
    public HumanPlayer(Pokemon pokemon, Item item) {
        super(pokemon, item);

    }
  /**
     * This is an method that gets the players pokemon.
     * 
     * @returns player's pokemon
     */
    public Pokemon getPokemon() {
        return pokemon;
    }
  /**
     * This is an method that sets the players pokemon.
     * 
     * @param pokemon
     */
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
   /**
     * This is an method that gets the players item.
     * 
     * @return item
     */
    public Item getItem() {
        return item;
    }
  /**
     * This is an method that sets the players item.
     * 
     * @param item
     */
    public void setItem(Item item) {
        this.item = item;
    }
  /**
     * This is an abstract method that lets the player run away.
     *
     */
    @Override
    public void run() {
        System.out.println("You escaped");
        this.getPokemon().setHP(this.getPokemon().getHP());
    }
 /**
     * This is an method that lets the player use an item on their pokemon.
     * 
     * @param pokemon
     */
    public void use(Pokemon pokemon) {
        super.item.use(pokemon);
    }
  /**
     * This is an  method creates a new pokemon with attacks
     * 
     * @param pokemon The players pokemon.
     * @returns new pokemon
     */
    @Override
    public Pokemon createPokemon(Pokemon pokemon) {

        System.out.print("Choose your Pokemon!\nWhat is its Name?: ");
        String name = scanner.nextLine();
        pokemon.setName(name);
        System.out.println("\nWhats that Type!: ");
        String type = scanner.nextLine();
        pokemon.setType(type);
        System.out.println("\nHow much health?: ");
        while (!scanner.hasNextDouble()) {
            scanner.nextLine(); 
            System.out.print("Invalid input. Please enter a valid integer: ");
        }
        double hp = scanner.nextDouble();
        pokemon.setHP(hp);
        pokemon.setAttackList();

        return pokemon;

    }
/**
 * This is an method that displays a menu to let the human plaer battle the computer player.
 * 
 * @param pokemon1
 * @param pokemon2
 * @param player2
 */
    @Override
    public void BattleMenu(Player player2, Pokemon pokemon1, Pokemon pokemon2) {

        System.out.println("Battle Begins! Not so wild Pokemon appeared!");
        System.out.println("1) Attack         2)Stats");
        System.out.println("3) Item           4)Run");

        while (!scanner.hasNextInt()) {
            scanner.nextLine(); 
            System.out.print("Invalid input. Please enter a valid integer: ");
        }
        int choose = scanner.nextInt();
        while (choose >= 0) {
            switch (choose) {
                case 1:
                    int attack = pokemon1.AttackMenu();
                    pokemon1.attack(pokemon2, attack);
                    if (pokemon1.getCurrentHP() <= 0 || pokemon2.getCurrentHP() <= 0) {
                        pokemon1.setHP(pokemon1.getHP());
                        for (int i = 0; i < pokemon1.getAttackList().size(); i++) {
                            pokemon1.getAttackList().get(i).setCurrentPP(pokemon1.getAttackList().get(i).getPowerPoint());
                        }
                        return;
                    }
                    player2.BattleMenu(this, pokemon1, pokemon2);
                    break;
                case 2:
                    System.out.println(pokemon1);
                    System.out.println("Current HP:" + pokemon1.getCurrentHP() + "/" + pokemon1.getHP());
                    break;
                case 3:
                    this.use(pokemon1);
                    player2.BattleMenu(this, pokemon1, pokemon2);
                    break;
                case 4:
                    this.run();
                    pokemon2.setHP(pokemon2.getHP());
                    return;
                case -1:
                    break;

            }
            if (pokemon1.getCurrentHP() <= 0 || pokemon2.getCurrentHP() <= 0) {
                pokemon1.setHP(pokemon1.getHP());
                pokemon2.setHP(pokemon2.getHP());
                for (int i = 0; i < pokemon1.getAttackList().size(); i++) {
                    pokemon1.getAttackList().get(i).setCurrentPP(pokemon1.getAttackList().get(i).getPowerPoint());

                }
                return;
            }
            System.out.println("1) Attack         2)Stats");
            System.out.println("3) Item           4)Run");
            while (!scanner.hasNextInt()) {
                scanner.nextLine(); 
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
            choose = scanner.nextInt();
        }

    }

}
