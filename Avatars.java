import java.util.Scanner;
import java.util.ArrayList;

public class Avatars {

    private String name;
    private int atk;
    private int def;
    private int hp;
    private String specialMove;

    // Common attack moves shared by all avatars
    private static final ArrayList<String> commonMoves = new ArrayList<>();

    static {
        commonMoves.add("Punch");
        commonMoves.add("Kick");
        commonMoves.add("Headbutt");
    }

    public Avatars(String name, int atk, int def, int hp, String specialMove) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
        this.specialMove = specialMove;
    }

    // User's turn
    public void yourTurn(int myHp, int foeHp, Avatars you, Avatars foe) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your move:");
        for (int i = 0; i < commonMoves.size(); i++) {
            System.out.println((i + 1) + ". " + commonMoves.get(i));
        }
        System.out.println((commonMoves.size() + 1) + ". " + this.specialMove);

        int choice;
        try {
            choice = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Defaulting to Punch.");
            choice = 1;
        }

        String selectedMove;
        if (choice >= 1 && choice <= commonMoves.size()) {
            selectedMove = commonMoves.get(choice - 1);
        } else if (choice == commonMoves.size() + 1) {
            selectedMove = specialMove;
        } else {
            System.out.println("Invalid choice. Defaulting to Punch.");
            selectedMove = "Punch";
        }

        int damage = you.atk;
        System.out.println(you.name + " used " + selectedMove + "!");
        foe.hp -= damage;
        if (foe.hp < 0) {
            foe.hp = 0;
        }
        System.out.println(foe.name + " has " + foe.hp + " HP left.");
    }

    // Foe's turn (automatic)
    public void foeTurn(Avatars you, Avatars foe) {
        System.out.println(foe.name + " attacks!");
        int damage = foe.atk;
        you.hp -= damage;
        if (you.hp < 0) {
            you.hp = 0;
        }
        System.out.println(you.name + " has " + you.hp + " HP left.");
    }

    // Healing method
    public void heal(String userInput, Avatars you) {
        int healAmount = 10;
        you.hp += healAmount;
        System.out.println(
                "You ate the berries and gained " + healAmount + " HP! New HP: " + you.hp);
    }

    // Check if dead and print message
    public void whenDead(int foeHp, int yourHp, Avatars foe, Avatars you) {
        if (yourHp <= 0) {
            System.out.println("You have been defeated. Game over.");
            System.exit(0);
        } else if (foeHp <= 0) {
            System.out.println("You defeated " + foe.name + "!");
        }
    }

    // Getter methods
    public int getHp() {
        return this.hp;
    }

    public String getName() {
        return this.name;
    }
}
