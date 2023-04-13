import java.util.Scanner;

/**
 * This an abstract class that represents the Player.
 * It has a pokemon and an item.
 */
public abstract class Player implements Item {

    Scanner scanner = new Scanner(System.in);
    /**
     * The players pokemons
     */
    protected Pokemon pokemon;
    /**
     * The players item
     */
    protected Item item;

    /**
     * Constructs a new Player object with the given pokemon and items.
     * 
     * @param pokemon The players pokemon.
     * @param item    The players item
     */
    public Player(Pokemon pokemon, Item item) {
        this.pokemon = pokemon;
        this.item = item;
    }

    /**
     * This is an abstract method Creates a new pokemon with attacks
     * 
     * @param pokemon The players pokemon.
     * @returns new pokemon
     */
    public abstract Pokemon createPokemon(Pokemon pokemon);

    /**
     * This is an abstract method that gets the players pokemon.
     * 
     * @returns player's pokemon
     */
    public abstract Pokemon getPokemon();

    /**
     * This is an abstract method that sets the players pokemon.
     * 
     * @param pokemon
     */
    public abstract void setPokemon(Pokemon pokemon);

    /**
     * This is an abstract method that gets the players item.
     * 
     * @return item
     */
    public abstract Item getItem();

    /**
     * This is an abstract method that sets the players item.
     * 
     * @param item
     */
    public abstract void setItem(Item item);

    /**
     * This is an abstract method that lets the player run away.
     *
     */
    public abstract void run();

/**
 * This is an abstract method that displays a menu to let the human plater battle the computer player.
 * 
 * @param pokemon1
 * @param pokemon2
 * @param player2
 */
    public abstract void BattleMenu(Player player2, Pokemon pokemon1, Pokemon pokemon2);

}
