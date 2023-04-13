/**
 * This an class that represents the Computer Player.
 * It has a pokemon and an item.
 */
public class ComputerPlayer extends Player {

    /**
     * Constructs a new Player object with the given pokemon and items.
     * 
     * @param pokemon The players pokemon.
     * @param item    The players item
     */
    public ComputerPlayer(Pokemon pokemon, Item item) {
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

        System.out.println(this.getPokemon().getName() + " escaped");

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
     * This is an method that displays a menu to let the human player battle the
     * computer player.
     * 
     * @param pokemon1
     * @param pokemon2
     * @param player2
     */
    @Override
    public void BattleMenu(Player player1, Pokemon pokemon1, Pokemon pokemon2) {

        int rand = (int) Math.floor(Math.random() * 3);
        while (rand >= 0) {
            switch (rand) {
                case 0:
                    this.use(pokemon2);
                    return;
                case 1:
                    int attack = 1;
                    pokemon2.attack(pokemon1, attack);
                    return;
                case 2:
                    this.run();
                    pokemon1.setCurrentHP(0);
                    return;

            }

        }

    }
   /**
     * The three methods below are Unimplemented method
     * 
     * @method createPokemon
     */
    @Override
    public Pokemon createPokemon(Pokemon pokemon) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPokemon'");
    }

}
