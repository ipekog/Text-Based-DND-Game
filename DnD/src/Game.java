import java.util.Scanner;
public class Game {

    // constants
    final String BATTLE_MESSAGE = "You encountered a monster!";

    // properties
    Scanner inpýt;

    boolean gameOver;
    Hero hero;

    String mainStory = "You wake up in a ........." + "\n" +
                       "You slowly enter an inn where you plan to stay and decide what you do" + "\n" +
                       "After embarking on a journey you encounter your first monster." + "\n" +
                       "You encountered a monster! " + "\n" +
                       "---Message----" + "\n" +
                       "---Monster Name---" + "\n" +
                       "---Monster hp---" + "\n" +
                       "---Monster ad---" + "\n" +
                       "---Monster type---" + "\n" +
                       "---Monster award---" + "\n" +
                       "After defeating the monster, you pick up your pace and continue on your adventure" + "\n";

    // constructor
    public Game() {

        gameOver = false;
        inpýt = new Scanner(System.in);
    }


    // methods

    // game main method
    public void run() {
        String userInput = "";
        // creates the character and prints the introductory message?
        setUp();

        // main game loop
        while(!gameOver) {

            inpýt.nextLine();
            gameOver = true;
            //hero.setHp(0);



        }

        // When the game is over and the user died
        if(hero.getHp() <= 0) {
            System.out.println("Your life flashes before your eyes as you silently curse at the monster that just killed you." + "\n" +
                               "As your conscious drifts away, two options appear in your mind as if they were a message from the java gods." + "\n" +
                               "New game?" + "\n" +
                               "Quit?");

        }
        // when the game is over and the user beat the game
        else {
            System.out.println("Congratulations, you beat the game. While our tale comes to a close, " + hero.getName() +
                               " will carry on his/her adventures in remembrance of you. " + "\n" +
                               "You can either quit or start over." + "\n"+
                               "New game?" + "\n" +
                               "Quit?");
        }

        while(!(userInput.equalsIgnoreCase("New Game") || userInput.equalsIgnoreCase( "Quit"))) {
            userInput = inpýt.nextLine();
            if(userInput.equalsIgnoreCase("New Game")) {
                reset(); // gereksiz olabilir idk
                run();
            }
            else if(userInput.equalsIgnoreCase("Quit")) {
                // end of game message
                System.out.println("Thank you for playing the game. We hope you've enjoyed your experience.");
                break;
            }
        }
    }

    // asks the user for inputs and sets up the game ( creates the hero )
    public void setUp() {
        String name,characterClass;
        System.out.println("Welcome to DnD" + "\n" + "Please enter the name of your character.");
        name = inpýt.nextLine();
        System.out.println("Now you should choose between three classes. Each has their unique attribute so chose wisely." + "\n"
                          +"Your choices are: Warrior, Sorcerer and Rogue. Please write the class you want."); // classlarýn ne yaptýðý eklenebilir

        characterClass = "";
        // if the character class entered is not valid, the loop continues to scan for a valid class name
        while(!characterClass.equalsIgnoreCase("Warrior") && !characterClass.equalsIgnoreCase("Rogue") && !characterClass.equalsIgnoreCase("Sorcerer")) {
            characterClass = inpýt.nextLine();
            if(characterClass.equalsIgnoreCase("Warrior")) {
                hero = new Warrior(name, 100, 10, "--Warrior Skill--", "Warrior", 2 );
                System.out.println("Congratulations " + name + ", you became a warrior. Warriors have stamina which can be used to .......");
                break;
            } 
            else if(characterClass.equalsIgnoreCase("Sorcerer")) {
                hero = new Sorcerer(name, 100, 10, "--Warrior Skill--", "Sorcerer", 2 );
                System.out.println("Congratulations " + name + ", you became a sorcerer. Sorcerers have mana which can be used to .......");
                break;
            } 
            else if( characterClass.equalsIgnoreCase("Rogue")) {
                hero = new Rogue(name, 100, 10, "--Warrior Skill--", "Rogue", 2 );
                System.out.println("Congratulations " + name + ", you became a rogue. Rogues have energy which can be used to .......");
                break;
            }
            // prompt to the user if he enters a wrong class name
            System.out.println( name + " kindly asks you to be more careful of your spelling as (s)he wonders what will become of him/her with such an incompetent master" +
                                " who fails at the simplest task of choosing a class." + "\n" +
                                characterClass + " is not a class, please choose a class.");
        }


    }

    // resets the game if you press the new game button after dying or completing the story
    public void reset() {
        hero = null;
        gameOver = false;
        inpýt = new Scanner(System.in);
    }

    // method for the battle
    // Returns true if the hero died, returns false otherwise
    public boolean battle() {

        return false;
    }


}
