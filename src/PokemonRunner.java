import java.util.ArrayList;
import java.util.Scanner;

public class PokemonRunner {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Pokemon pokemon = new HumansPokemon();
        Pokemon pokemon2 = new ComputersPokemon();
        Potion potion = new Potion();
        SuperPotion superPotion = new SuperPotion();
        Player player = new HumanPlayer(pokemon, potion);
        Player player2 = new ComputerPlayer(pokemon2, superPotion);

        
        System.out.println("------------POKEMON LAB HAS BEGAN!!!------------");
        System.out.println("1) Choose to Battle        2)Check Pokemon");
        System.out.println("3) Speak to Pokemon        4)Check Item");
        System.out.println("5) Give Nickname           6)Teach New Attacks");
        System.out.println("7) Change Pokemon");
        System.out.println("[Enter -1 to Exit]");
        while (!scanner.hasNextInt()) {
            scanner.nextLine(); 
            System.out.println("Invalid input. Please enter a valid integer: ");
        }
        int choice = scanner.nextInt();

        while (choice >= 0) {
            potion.setCapacity(5);
            superPotion.setCapacity(5);
            switch (choice) {
                case 1:
                System.out.println("\n");
                    player.BattleMenu(player2, pokemon, pokemon2);
                    break;
                case 2:
                System.out.println("\n");
                    System.out.println(pokemon);
                    System.out.println("-----------------------------------");
                    System.out.println("1) Check Attacks        2)Go back");
                    while (!scanner.hasNextInt()) {
                        scanner.nextLine();
                        System.out.print("Invalid input. Please enter a valid integer: ");
                    }
                    choice = scanner.nextInt();
                    if (choice == 1) {
                        ArrayList<Attack> attacks = pokemon.getAttackList();
                        for (int i = 0; i < attacks.size(); i++)
                            System.out.println(i + 1 + " " + attacks.get(i));
                    }
                    break;
                case 3:
                System.out.println("\n");
                    pokemon.speak();
                    break;
                case 4:
                System.out.println("\n");
                    potion.itemDescription();
                    break;
                case 5:
                System.out.println("\n");
                    System.out.println("-----------------------------------");
                    System.out.println("Enter new Nickname: ");
                    String name = scanner.nextLine();
                    name = scanner.nextLine();
                    pokemon.setName(name);
                    break;
                case 6:
                    System.out.println("\n");
                    pokemon.changeAttacks();
                    break;
                case 7:
                    System.out.println("\n");
                    player.createPokemon(pokemon);
                case -1:
                    break;
            }
            System.out.println("---------------------------------------------");
            System.out.println("1) Choose to Battle        2)Check Pokemon");
            System.out.println("3) Speak to Pokemon        4)Check Item");
            System.out.println("5) Give Nickname           6)Teach New Attacks");
            System.out.println("7) Change Pokemon");
            System.out.println("[Enter -1 to Exit]");
            while (!scanner.hasNextInt()) {
                scanner.nextLine(); 
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
            choice = scanner.nextInt();

        }
        scanner.close();
    }

}
