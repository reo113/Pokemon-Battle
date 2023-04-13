import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents a Pokemon.
 * It has a name , health, type and list of attacks.
 */
public abstract class Pokemon {

  Scanner scanner = new Scanner(System.in);
  /**
   * The hp of the pokemon.
   */
  protected double baseHP;
  /**
   * The hp of the pokemon during battle.
   */
  protected double currentHP;
  /**
   * The name of the Pokemon.
   */
  protected String name;
  /**
   * The type of the Pokemon.
   */
  protected String type;
  /**
   * The list of attacks for the pokemon.
   */
  protected ArrayList<Attack> attackList = new ArrayList<>(4);

  /**
   * Constructs a default new Pokemon object.
   * 
   * @param name   The name of the Pokemon.
   * @param baseHP The hp of the attack.
   * @param type   The type of Pokemon.
   */
  Pokemon() {
    this.baseHP = 1000;
    currentHP = this.baseHP;
    this.name = "";
    this.type = "";
  }

  /**
   * Constructs a default new Pokemon object with the given name, hp ,type..
   * 
   * @param name       The name of the Pokemon.
   * @param baseHP     The hp of the attack.
   * @param type       The type of Pokemon.
   * @param attackList The list of attacks for the pokemon.
   */
  Pokemon(double baseHP, String name, String type, ArrayList<Attack> attackList) {
    this.baseHP = baseHP;
    currentHP = baseHP;
    this.name = name;
    this.type = type.toLowerCase();
    this.attackList = attackList;

  }

  /**
   * The list of Pokemon types to be used for battles to determine
   * the amount of damage done.
   * Note: the first index of the list is strictly used to distinguish between
   * types.
   * Rules of the indices: basic: 0, super: 1, not very eff: 2, no eff: 3
   */
  private List<Integer> bugs = Arrays.asList(0, 0, 0, 0, 0, 1, 1, 0, 2, 0, 0, 0, 1, 0, 1, 0);
  private List<Integer> dragons = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
  private List<Integer> electric = Arrays.asList(2, 0, 0, 2, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0);
  private List<Integer> fighting = Arrays.asList(3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 2, 0);
  private List<Integer> fire = Arrays.asList(4, 2, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0, 1, 1);
  private List<Integer> flying = Arrays.asList(5, 2, 0, 1, 2, 0, 0, 0, 2, 3, 1, 0, 0, 0, 1, 0);
  private List<Integer> ghost = Arrays.asList(6, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0);
  private List<Integer> grass = Arrays.asList(7, 1, 0, 2, 0, 1, 1, 0, 2, 2, 1, 0, 1, 0, 0, 2);
  private List<Integer> ground = Arrays.asList(8, 0, 0, 3, 0, 0, 0, 0, 1, 0, 1, 0, 2, 0, 0, 1);
  private List<Integer> ice = Arrays.asList(9, 0, 0, 0, 1, 1, 0, 0, 0, 0, 2, 0, 0, 0, 1, 2);
  private List<Integer> normal = Arrays.asList(10, 0, 0, 0, 1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0);
  private List<Integer> poison = Arrays.asList(11, 1, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 2, 1, 0, 0);
  private List<Integer> psychic = Arrays.asList(12, 1, 0, 0, 2, 0, 0, 3, 0, 0, 0, 0, 0, 2, 0, 0);
  private List<Integer> rock = Arrays.asList(13, 2, 0, 0, 1, 2, 2, 0, 1, 1, 0, 0, 2, 0, 2, 1);
  private List<Integer> water = Arrays.asList(14, 0, 0, 1, 0, 2, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0);

  /**
   * The hashmap of Pokemon types to be used for battles to determine
   * the amount of damage done.
   */
  private final HashMap<String, List<Integer>> pokeType = new HashMap<String, List<Integer>>() {
    {
      put("bug", bugs);
      put("dragons", dragons);
      put("electric", electric);
      put("fighting", fighting);
      put("fire", fire);
      put("flying", flying);
      put("ghost", ghost);
      put("grass", grass);
      put("ground", ground);
      put("ice", ice);
      put("normal", normal);
      put("poison", poison);
      put("psychic", psychic);
      put("rock", rock);
      put("rock", rock);
      put("water", water);
    }

  };

  /**
   * @return The pokemons type.
   */
  public HashMap<String, List<Integer>> getPokeType() {
    return pokeType;
  }

  /**
   * This is an abstract method that attacks an opponent.
   * 
   * @param other       The opponents Pokemon.
   * @param attackIndex the chosen attack to use.
   *
   */
  public abstract void attack(Pokemon other, int attackIndex);

  public abstract void speak(); // This is an abstract method that lets the pokemon speak to the player.

  /**
   * This is an abstract method that retursn the pokemons type.
   * 
   * @return type
   */
  public abstract String getType();

  /**
   * This is an abstract method that sets the pokemons type.
   * 
   * @param type
   */
  public abstract void setType(String type);

  /**
   * This is an abstract method that sets the pokemons name.
   * 
   * @param name
   */
  public abstract void setName(String name);

  /**
   * This is an abstract method that returns the pokemons name.
   * 
   * @return name
   */
  public abstract String getName();

  /**
   * This is an abstract method that returns the pokemons hp.
   * 
   * @return baseHP
   */
  public abstract double getHP();

  /**
   * This is an abstract method that sets the pokemons hp.
   * 
   * @param baseHP
   */
  public abstract void setHP(double hp);

  /**
   * This is an abstract method that sets the pokemons hp during battle.
   * 
   * @param hp
   */
  public abstract void setCurrentHP(double hp);

  /**
   * This is an abstract method that gets the pokemons hp during battle.
   * 
   * @return currentHP
   * 
   */
  public abstract double getCurrentHP();

  public abstract void setAttackList(); // This is an abstract method that sets the pokemons attacks.

  /**
   * This is an abstract method that gets the pokemons attacks.
   * 
   * @return attackList
   */
  public abstract ArrayList<Attack> getAttackList();

  /**
   * This is an abstract method that displays the pokemons attacks and allows the
   * user to chose from their list of attacks.
   * 
   * @return an integer that correpsonses to the indices of the attack
   */
  public abstract int AttackMenu();

  /**
   * This is an abstract method that allows the users to replace one or all their
   * attacks.
   * 
   */
  public abstract void changeAttacks();

}
