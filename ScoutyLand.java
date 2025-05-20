import java.util.Scanner;
import java.util.ArrayList;

public class ScoutyLand {

    public static void main(String[] args) {
        //Create objects for avatar options 
        Avatars scout = new Avatars("Scout", 8, 2, 20, "Beg");
        Avatars winston = new Avatars("Winston", 5, 1, 30, "Sneeze");
        Avatars sally = new Avatars("Sally", 5, 5, 10, "Bite");
        Avatars rocky = new Avatars("Rocky", 10, 1, 10, "Parkour");
        Avatars nouchka = new Avatars("Nouchka", 7, 2, 20, "Lick");
        ArrayList<Avatars> avatarList = new ArrayList<Avatars>();

        //Add created objects to ArrayList
        avatarList.add(scout);
        avatarList.add(winston);
        avatarList.add(sally);
        avatarList.add(rocky);
        avatarList.add(nouchka);

        //Initialize Scanner 
        Scanner input = new Scanner(System.in);

        System.out.println(
                "You are about to enter Scouty Land. Before you begin, please choose your avatar.");
        System.out.println(" ");

        //Print avatar options
        for (int i = 0; i < avatarList.size(); i++) {
            System.out.println(avatarList.get(i).getName());
        }

        System.out.println(" ");
        System.out.println("Chosen avatar:");
        String avatarChoice = input.nextLine();

        //Check which avatar name is identical to the name the user inputted and user remprompted if invalid name inputted
        while (true) {
            if (avatarChoice.equalsIgnoreCase("Scout") || avatarChoice.equalsIgnoreCase("Winston")
                    || avatarChoice.equalsIgnoreCase("Sally") || avatarChoice.equalsIgnoreCase(
                    "Rocky") || avatarChoice.equalsIgnoreCase("Nouchka")) {
                break;
            } else {
                System.out.println("Please enter a valid avatar name");
                avatarChoice = input.nextLine();
            }
        }

        //Allows proper index of chosen avatar to be found
        int count = 0;
        while (!(avatarChoice.equalsIgnoreCase(avatarList.get(count).getName()))) {
            count++;
        }

        Avatars currentAvatar = avatarList.get(count);
        System.out.println(" ");
        System.out.println(currentAvatar.getName() + " is your chosen avatar!!");

        //Prints "Great Choice" if user chooses Scout as their avatar 
        if (currentAvatar.getName().equalsIgnoreCase("Scout")) {
            System.out.println("Great choice ;)");
        }

        System.out.println(" ");
        System.out.println("You are now entering Scouty Land! Good luck!");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(currentAvatar.getName() + ":.....where am I??");
        System.out.println(
                currentAvatar.getName() + ": Oh no! Where are my friends?! I need to find them!!");
        System.out.println(currentAvatar.getName() + " noticed a rustle in the mysterious forest.");
        System.out.println("Do you want to enter the mysterious forest?");
        String enterForest = input.nextLine();

        //Prints response based on user input and remprompts if invalid response inputted
        while (true) {
            if (enterForest.equalsIgnoreCase("Yes")) {
                System.out.println("You are now entering the mysterious forest");
                break;
            } else if (enterForest.equalsIgnoreCase("No")) {
                System.out.println("What a terrible friend! " + currentAvatar.getName()
                        + " never found their friends and remained lonely forever. Try again.");
                System.exit(0);
            } else {
                System.out.println("Please enter a valid response");
                enterForest = input.nextLine();
            }
        }

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Grunt Monster: NOBODY ENTERS MY FOREST!!!!");
        System.out.println(" ");
        Avatars gruntMonster = new Avatars("Grunt Monster", 6, 1, 10, "Null");
        System.out.println(currentAvatar.getName() + " is approached by " + gruntMonster.getName());

        //Runs methods until the hp of chosen avatar or foe drops to 0 or below
        while (currentAvatar.getHp() > 0 && gruntMonster.getHp() > 0) {
            gruntMonster.foeTurn(currentAvatar, gruntMonster);
            currentAvatar.whenDead(gruntMonster.getHp(), currentAvatar.getHp(), gruntMonster,
                    currentAvatar);
            currentAvatar.yourTurn(currentAvatar.getHp(), gruntMonster.getHp(), currentAvatar,
                    gruntMonster);
        }

        //Calls method to check which response to print based on if chosen avatar or foe hp dropped to 0 or below
        currentAvatar.whenDead(gruntMonster.getHp(), currentAvatar.getHp(), gruntMonster,
                currentAvatar);

        System.out.println(" ");
        System.out.println("Grunt Monster: Nooo..must protect...the king...");
        System.out.println(" ");
        System.out.println("You came across a pile of berries. Do you want to eat them?");
        String postGruntBerries = input.nextLine();

        //If user inputs yes then calls heal method
        if (postGruntBerries.equalsIgnoreCase("Yes")) {
            currentAvatar.heal(postGruntBerries, currentAvatar);
        }
        System.out.println(" ");
        System.out.println(currentAvatar.getName() + " found a palace.");
        System.out.println("Do you want to enter the palace?");
        String enterPalace = input.nextLine();

        //Prints response based on user input and remprompts if invalid response inputted
        while (true) {
            if (enterPalace.equalsIgnoreCase("Yes")) {
                System.out.println("You are now entering the palace.");
                break;
            } else if (enterPalace.equalsIgnoreCase("No")) {
                System.out.println(
                        "As you waited outside the palace you were attacked by a hoard of monsters and perished. Try again");
                System.exit(0);
            } else {
                System.out.println("Please enter a valid response");
                enterPalace = input.nextLine();
            }
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        Avatars guard = new Avatars("Royal Guard", 7, 3, 10, "Null");
        System.out.println("Royal Guard: Who dares to enter the king's palace!?");
        System.out.println("Royal Guard: I will destroy you!!!");
        System.out.println(" ");
        System.out.println(currentAvatar.getName() + " is approached by " + guard.getName());

        //Calls method to check which response to print based on if chosen avatar or foe hp dropped to 0 or below
        while (currentAvatar.getHp() > 0 && guard.getHp() > 0) {
            guard.foeTurn(currentAvatar, guard);
            currentAvatar.whenDead(guard.getHp(), currentAvatar.getHp(), guard, currentAvatar);
            currentAvatar.yourTurn(currentAvatar.getHp(), guard.getHp(), currentAvatar, guard);
        }

        //Calls method to check which response to print based on if chosen avatar or foe hp dropped to 0 or below
        currentAvatar.whenDead(guard.getHp(), currentAvatar.getHp(), guard, currentAvatar);

        System.out.println(" ");
        System.out.println(
                "Royal Guard: You may have defeated me but you'll never defeat the king....");
        System.out.println(" ");
        System.out.println("You came across a pile of berries. Do you want to eat them?");
        String postGuardBerries = input.nextLine();

        //If user inputs yes then calls heal method
        if (postGuardBerries.equalsIgnoreCase("Yes")) {
            currentAvatar.heal(postGuardBerries, currentAvatar);
        }

        System.out.println(" ");
        System.out.println(
                "You wander the palace until you enter a giant door labeled 'Throne Room'");
        System.out.println("Would you like to enter?");
        String enterThroneRoom = input.nextLine();

        //Prints response based on user input and remprompts if invalid response inputted
        while (true) {
            if (enterThroneRoom.equalsIgnoreCase("Yes")) {
                System.out.println("You are now entering the throne room.");
                break;
            } else if (enterThroneRoom.equalsIgnoreCase("No")) {
                System.out.println(
                        "As you waited outside the throne room you were captured by knights and thrown into the palace prison, never to be seen again");
                System.exit(0);
            } else {
                System.out.println("Please enter a valid response");
                enterThroneRoom = input.nextLine();
            }
        }

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        //Removes chosen avatar from list of avatars 
        for (int i = 0; i < avatarList.size(); i++) {
            if (avatarList.get(i).getName().equalsIgnoreCase(currentAvatar.getName())) {
                avatarList.remove(i);
            }
        }

        //Finds random index of 0-4 and uses random index to set new object equal to random avatar in list of avatars
        int index = (int) (Math.random() * avatarList.size());
        Avatars king = avatarList.get(index);

        System.out.println("A dark figure sits upon the throne...");
        System.out.println("As you approach it looks familiar..");
        System.out.println("Its......" + king.getName());
        System.out.println(king.getName() + ": " + "WHO ENTERS MY THRONE ROOM!!!");
        System.out.println(king.getName() + ": " + currentAvatar.getName() + "?");
        System.out.println(
                currentAvatar.getName() + ": " + king.getName() + " what are you doing here?");
        System.out.println(king.getName()
                + ": You dont remember? YOU DONT REMEMBER THE PAIN YOU PUT ME THROUGH?!");
        System.out.println(
                currentAvatar.getName() + ": Sorry...I don't know what your talking about");
        System.out.println(king.getName() + ": You really don't remember anything?");
        System.out.println(currentAvatar.getName() + ": Yes");
        System.out.println(king.getName() + ": YOU STOLE MY PRECIOUS SQUEAKY TOY!!! ");
        System.out.println(king.getName()
                + ": You were banished and thrown into the forest. I thought we'd never see you again...");
        System.out.println(king.getName()
                + ": I felt bad about kicking you out but now that I know you don't even care...YOU WILL PAY!!!!");
        System.out.println(" ");
        System.out.println(currentAvatar.getName() + " is approached by " + king.getName());

        //Calls method to check which response to print based on if chosen avatar or foe hp dropped to 0 or below
        while (currentAvatar.getHp() > 0 && king.getHp() > 0) {
            king.foeTurn(currentAvatar, king);
            currentAvatar.whenDead(king.getHp(), currentAvatar.getHp(), king, currentAvatar);
            currentAvatar.yourTurn(currentAvatar.getHp(), king.getHp(), currentAvatar, king);
        }

        //Calls method to check which response to print based on if chosen avatar or foe hp dropped to 0 or below
        currentAvatar.whenDead(king.getHp(), currentAvatar.getHp(), king, currentAvatar);
        System.out.println(" ");
        System.out.println(king.getName() + ":....how did you beat me??");
        System.out.println(currentAvatar.getName() + ": " + king.getName()
                + " I'm really sorry for taking your squeaky toy but I don't remember anything..all I remember is waking up in a scary forest");
        System.out.println(king.getName()
                + ": Oh. You did hit your head pretty hard on the way out. Perhaps thats how you lost your memories.");
        System.out.println(king.getName()
                + ": Anyways, I'm sorry for being such a jerk and honestly I've missed you a lot...");
        System.out.println(king.getName() + ": Will you forgive me?");
        System.out.println("Do you want to forgive " + king.getName() + " ?");
        String forgiveKing = input.nextLine();

        //Prints response based on user input and remprompts if invalid response inputted
        while (true) {
            if (forgiveKing.equalsIgnoreCase("Yes")) {
                break;
            }
            //Remprompts user to respond to question again in order to be certain of their answer
            else if (forgiveKing.equalsIgnoreCase("No")) {
                System.out.println(king.getName() + ": Oh no...I am very very sad.....");
                System.out.println("Do you want to forgive your friend?");
                String forgiveFriend = input.nextLine();
                if (forgiveFriend.equalsIgnoreCase("Yes")) {
                    break;
                }
                System.out.println(
                        "You escaped with your life but you lost one of your most valuable treasures....friendship.");
                System.exit(0);
            } else {
                System.out.println("Please enter a valid response");
                forgiveKing = input.nextLine();
            }
        }

        System.out.println(king.getName() + ": You really forgive me?? Thank you!!");
        System.out.println(" ");
        System.out.println("Congratulations!!! You won the game and kept your friend!!!");


    }
}
