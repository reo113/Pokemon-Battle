/**
 * This class represents an useable item called a Potion.
 * 
 */
public class Potion implements Item {
    /**
     * the initial amount of items
     */
    private int capacity = 5;

    /**
     * This is an method displays the items details.
     * 
     */
    public void itemDescription() {
        System.out.println("Potion:\nHeals your Pokemon by 20 hp\n");
    }

    /**
     * This is an method gets the current capacity.
     * 
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }
      /**
     * This is an method sets the current capacity.
     * 
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    /**
     * This is an method that lets the player use an item on their pokemon.
     * 
     * @param pokemon
     */
    @Override
    public void use(Pokemon pokemon) {
        if (getCapacity() <= 0) {
            System.out.println(pokemon.getName() + " has no more Potions");
            return;
        }
        System.out.println(pokemon.getName() + " used a potion.");
        double health = pokemon.getCurrentHP() + 20;
        if (health > pokemon.getHP()) {
            pokemon.setCurrentHP(pokemon.getHP());
        } else {
            pokemon.setCurrentHP(health);
        }
        System.out.println(pokemon.getName() + " health is " + pokemon.getCurrentHP());
        capacity -= 1;
    }

}
