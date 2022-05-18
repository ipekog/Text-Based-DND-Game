import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class Main {
	private static File musicFile1 = new File("C:\\Users\\IPEK\\Downloads\\DnD_music_clip1.wav");
	private static File musicFile2 = new File("C:\\Users\\IPEK\\Downloads\\DnD_music_clip2.wav");
	private static File musicFile3 = new File("C:\\Users\\IPEK\\Downloads\\DnD_music_clip3.wav");
	private static File musicFile4 = new File("C:\\Users\\IPEK\\Downloads\\Dnd_music_clip4.wav");
	private static Clip clip1 = null, clip2 = null, clip3 = null, clip4 = null;
    
	public static void main(String[] args) throws InterruptedException, LineUnavailableException, IOException, UnsupportedAudioFileException 
	{
		String name;
		String type;

		Scanner sc = new Scanner(System.in);
		String command = "";
		boolean start = false;
		Scenario scenario = new Scenario();
		setMusic(); // sets the music clips ready
		
		while (!start) // story starts
		{
			clip1.start(); // music
			clip1.loop(Clip.LOOP_CONTINUOUSLY);
			
			scenario.print(0, 14); // choose your name
			name = sc.nextLine();
			scenario.print(14, 18); // choose your class
			type = sc.nextLine();

			Hero hero = null;
			boolean chooseClass = true;

			// choosing class
			while (chooseClass) 
			{
				if (type.equals("1")) // pick Rogue
				{
					hero = new Rogue(name, 9, 1, "Twilight Robbery", "Rogue", 3);
					chooseClass = false;
				} 
				else if (type.equals("2")) // pick Sorcerer
				{
					hero = new Sorcerer(name, 10, 1, "Dance of the Light and Shadow", "Sorcerer", 3);
					chooseClass = false;
				} 
				else if (type.equals("3")) // pick Warrior
				{
					hero = new Warrior(name, 11, 1, "Machinegun Blow", "Warrior", 3);
					chooseClass = false;
				} 
				else 
				{
					System.out.println("Unknown command, please enter appropriate class!");
					type = sc.nextLine();
				}
			}

			// name + class
			System.out.println("\"I am a " + hero.getType() + ". They call me " + hero.getName() + " where I came from.\"");
			Thread.sleep(2000);
			System.out.println("\"I am an adventurer who travels a lot... So I can help you with your dragon problem.\"");
			Thread.sleep(2000);
			System.out.println("\"Also I really need the money for all the travelling not gonna lie....\"");
			Thread.sleep(2000);

			scenario.print(18, 26);
			
			// monster fight Centaur
			clip1.stop();
			clip2.start(); // music
			clip2.loop(Clip.LOOP_CONTINUOUSLY);
			
			Monster Centaur = new Monster("Centaur", 3, 1, "Animal", "2 potions");

			System.out.println("You encountered Centaur!");

			if (hero.type.equals("Rogue")) 
			{
				((Rogue) hero).printRogue();
			} 
			else if (hero.type.equals("Sorcerer")) 
			{
				((Sorcerer) hero).printSorcerer();
			} 
			else if (hero.type.equals("Warrior")) 
			{
				((Warrior) hero).printWarrior();
			}
			
			Centaur.printMonster();

			while (Centaur.getHp() > 0 && hero.getHp() > 0) 
			{
				System.out.println(" ");
				System.out.println("What would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Use Health Potion");
				System.out.println("\t3. Use Ultimate");
				System.out.println("\t4. Tease");
				command = sc.nextLine();

				if (command.equals("1")) 
				{
					hero.useAttack(Centaur);
				}
				else if (command.equals("2")) 
				{
					hero.usePotion();
				} 
				else if (command.equals("3")) 
				{
					if (hero.type.equals("Rogue"))
					{
						((Rogue) hero).useUltimate(Centaur);
					}
					else if (hero.type.equals("Sorcerer")) 
					{
						((Sorcerer) hero).useUltimate(Centaur);
					} 
					else if (hero.type.equals("Warrior")) 
					{
						((Warrior) hero).useUltimate(Centaur);
					}
				} 
				else if (command.equals("4")) 
				{
					hero.tease();
				} 
				else 
				{
					System.out.println("Unknown command!");
				}
			}
			if (hero.getHp() > 0) 
			{
				System.out.println("You earned 2 potions.");
				hero.setPotionC(hero.getPotionC() + 2);
			} 
			else 
			{
				break; // hero dead
			}
			
			scenario.print(26, 29);

			// monster fight Cyclops
			Monster Cyclops = new Monster("Cyclops", 3, 1, "3 IQ", "2 potions");

			System.out.println("You encountered Cyclops!");

			if (hero.type.equals("Rogue")) 
			{
				((Rogue) hero).printRogue();
			} 
			else if (hero.type.equals("Sorcerer")) 
			{
				((Sorcerer) hero).printSorcerer();
			} 
			else if (hero.type.equals("Warrior")) 
			{
				((Warrior) hero).printWarrior();
			}
			Cyclops.printMonster();

			while (Cyclops.getHp() > 0 && hero.getHp() > 0) 
			{
				System.out.println(" ");
				System.out.println("What would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Use Health Potion");
				System.out.println("\t3. Use Ultimate");
				System.out.println("\t4. Tease");
				command = sc.nextLine();

				if (command.equals("1")) 
				{
					hero.useAttack(Cyclops);
				} 
				else if (command.equals("2")) 
				{
					hero.usePotion();
				} 
				else if (command.equals("3")) 
				{
					if (hero.type.equals("Rogue")) 
					{
						((Rogue) hero).useUltimate(Cyclops);
					}
					else if (hero.type.equals("Sorcerer")) 
					{
						((Sorcerer) hero).useUltimate(Cyclops);
					} 
					else if (hero.type.equals("Warrior")) 
					{
						((Warrior) hero).useUltimate(Cyclops);
					}
				} 
				else if (command.equals("4")) 
				{
					hero.tease();
				}
				else {
					System.out.println("Unknown command!");
				}
			}
			if (hero.getHp() > 0) 
			{
				System.out.println("You earned 2 potions.");
				hero.setPotionC(hero.getPotionC() + 2);
			} 
			else 
			{
				break; // hero dead
			}
			
			clip2.stop();
			clip1.start(); // music
			clip1.loop(Clip.LOOP_CONTINUOUSLY);
			
			// puzzle 1 + choose path
			scenario.print(29, 31);
			
			suprise1(hero);
			
			scenario.print(31, 40);
			System.out.println("- Which path do you choose?");
			System.out.println("\t1. Left");
			System.out.println("\t2. Right");
			command = sc.nextLine();
			
			boolean choosePath = true;
			
			

			// choosing path
			while (choosePath) 
			{
				if (command.equals("1")) // path 1 Wolf
				{
					scenario.print(40, 41);
					
					clip1.stop();
					clip3.start(); // music
					clip3.loop(Clip.LOOP_CONTINUOUSLY);
					
					scenario.print(41, 46);
					Monster Wolf = new Monster("Wolf of the North Wind", 10, 5, "Miniboss", " your special power and 2 potions");
					
					System.out.println("You encountered Wolf of the North Wind!");
					if (hero.type.equals("Rogue")) 
					{
						((Rogue) hero).printRogue();
					} 
					else if (hero.type.equals("Sorcerer")) 
					{
						((Sorcerer) hero).printSorcerer();
					} 
					else if (hero.type.equals("Warrior")) 
					{
						((Warrior) hero).printWarrior();
					}
					
					Wolf.printMonster();
					while (Wolf.getHp() > 0 && hero.getHp() > 0) 
					{
						System.out.println(" ");
						System.out.println("What would you like to do?");
						System.out.println("\t1. Attack");
						System.out.println("\t2. Use Health Potion");
						System.out.println("\t3. Use Ultimate");
						System.out.println("\t4. Tease");
						command = sc.nextLine();

						if (command.equals("1")) 
						{
							hero.useAttack(Wolf);
						} 
						else if (command.equals("2")) 
						{
							hero.usePotion();
						}
						else if (command.equals("3")) 
						{
							if (hero.type.equals("Rogue")) 
							{
								((Rogue) hero).useUltimate(Wolf);
							} 
							else if (hero.type.equals("Sorcerer")) 
							{
								((Sorcerer) hero).useUltimate(Wolf);
							} 
							else if (hero.type.equals("Warrior")) 
							{
								((Warrior) hero).useUltimate(Wolf);
							}
						} 
						else if (command.equals("4"))
						{
							hero.tease();
						} 
						else
						{
							System.out.println("Unknown command!");
						}
					}
					if (hero.getHp() > 0)
					{
						System.out.println("You earned 2 potions and a mysterious special ability.");
						hero.setPotionC(hero.getPotionC() + 2);
					} 
					else 
					{
						break; // hero dead
					}
					scenario.print(52, 55);
					choosePath = false;
				} 
			
				else if (command.equals("2")) // path 2 Cthulhu
				{
					scenario.print(40, 41);
					
					clip1.stop();
					clip3.start(); // music
					clip3.loop(Clip.LOOP_CONTINUOUSLY);
					
					scenario.print(46, 52);
					Monster Cthulhu = new Monster("Cthulhu", 10, 5, "Miniboss", "your special power and 2 potions");
					
					System.out.println("You encountered Cthulhu!");
					if (hero.type.equals("Rogue")) 
					{
						((Rogue) hero).printRogue();
					} 
					else if (hero.type.equals("Sorcerer")) 
					{
						((Sorcerer) hero).printSorcerer();
					} 
					else if (hero.type.equals("Warrior"))
					{
						((Warrior) hero).printWarrior();
					}
					Cthulhu.printMonster();
					while (Cthulhu.getHp() > 0 && hero.getHp() > 0) 
					{
						System.out.println(" ");
						System.out.println("What would you like to do?");
						System.out.println("\t1. Attack");
						System.out.println("\t2. Use Health Potion");
						System.out.println("\t3. Use Ultimate");
						System.out.println("\t4. Tease");
						command = sc.nextLine();

						if (command.equals("1")) 
						{
							hero.useAttack(Cthulhu);
						} 
						else if (command.equals("2"))
						{
							hero.usePotion();
						} 
						else if (command.equals("3")) 
						{
							if (hero.type.equals("Rogue")) 
							{
								((Rogue) hero).useUltimate(Cthulhu);
							} 
							else if (hero.type.equals("Sorcerer")) 
							{
								((Sorcerer) hero).useUltimate(Cthulhu);
							} 
							else if (hero.type.equals("Warrior")) 
							{
								((Warrior) hero).useUltimate(Cthulhu);
							}
						} 
						else if (command.equals("4")) 
						{
							hero.tease();
						} 
						else 
						{
							System.out.println("Unknown command!");
						}
					}
					if (hero.getHp() > 0) 
					{
						System.out.println("You earned 2 potions and a mysterious special ability.");
						hero.setPotionC(hero.getPotionC() + 2);
					} 
					else 
					{
						break; // hero dead
					}
					scenario.print(54, 57);
					choosePath = false;
				}
				else 
				{
					System.out.println("Unknown command, please enter appropriate number!");
					command = sc.nextLine();
				}
			}
			
			

			clip3.stop();
			clip1.start(); // music
			clip1.loop(Clip.LOOP_CONTINUOUSLY);
			
			// puzzle 2 + Boss Dragon
			suprise2(hero);
			
			clip1.stop();
			clip4.start(); // music
			clip4.loop(Clip.LOOP_CONTINUOUSLY);
			scenario.print(58, 62);
			
			Monster Draconian = new Monster("Draconian", 20, 10, "Final Boss", "End");
			System.out.println("You encountered Draconian!");
			
			if (hero.type.equals("Rogue")) 
			{
				((Rogue) hero).printRogue();
			} 
			else if (hero.type.equals("Sorcerer")) 
			{
				((Sorcerer) hero).printSorcerer();
			} 
			else if (hero.type.equals("Warrior")) 
			{
				((Warrior) hero).printWarrior();
			}
			
			Draconian.printMonster();
			while (Draconian.getHp() > 0 && hero.getHp() > 0) 
			{
				System.out.println(" ");
				System.out.println("What would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Use Health Potion");
				System.out.println("\t3. Use Ultimate");
				System.out.println("\t4. Use Special");
				System.out.println("\t5. Tease");
				command = sc.nextLine();

				if (command.equals("1")) 
				{
					hero.useAttack(Draconian);
				} 
				else if (command.equals("2"))
				{
					hero.usePotion();
				}
				else if (command.equals("3")) // use ult
				{
					if (hero.type.equals("Rogue")) 
					{
						((Rogue) hero).useUltimate(Draconian);
					}
					else if (hero.type.equals("Sorcerer")) 
					{
						((Sorcerer) hero).useUltimate(Draconian);
					} 
					else if (hero.type.equals("Warrior")) 
					{
						((Warrior) hero).useUltimate(Draconian);
					}
				}
				else if (command.equals("4")) // use special
				{
					if (hero.type.equals("Rogue"))
					{
						((Rogue) hero).useSpecial(Draconian);
					} 
					else if (hero.type.equals("Sorcerer")) 
					{
						((Sorcerer) hero).useSpecial(Draconian);
					}
					else if (hero.type.equals("Warrior")) 
					{
						((Warrior) hero).useSpecial(Draconian);
					}
				} 
				else if (command.equals("5")) 
				{
					hero.tease();
				} 
				else 
				{
					System.out.println("Unknown command!");
				}
			}
			if (hero.getHp() > 0) 
			{
				clip4.stop();
				clip1.start(); // music
				clip1.loop(Clip.LOOP_CONTINUOUSLY);
				scenario.print(63, 73);
				clip1.stop();
				start = true;
			} 
			else 
			{
				break;
			}
		}
		clip1.stop();
		clip2.stop();
		clip3.stop();
		clip4.stop();
		sc.close();
	}

	// puzzle 1 
	private static void suprise1(Hero h)
	{
		Scanner sc = new Scanner(System.in);
		String answer = "";
		System.out.println("As you reached the well, you encounter a nympha wondering around it. She looks at you with great curiosity. You decide to approach her and she asks you a question: ");
		System.out.println("Many have heard me, yet nobody has seen me. I won’t speak back unless spoken to. What am I?");
		answer = sc.nextLine();
		
		if (answer.equalsIgnoreCase("echo") || answer.equalsIgnoreCase("an echo")) {
			System.out.println("After hearing your answer, the nympha replied: \"I see that your intellegence is on par with your strength. May this bottle save you in a time of crisis.");
			System.out.println("You have earned a healing potion!");
			h.setPotionC(h.getPotionC() + 1);
		} 
		else // wrong answer
		{
			System.out.println("Beware adventurer, I've heard you've got strength but you mustn't forget that even it must bow before wisdom");
			System.out.println("May this lesson guide you through your battles.");
		}
	}

	// puzzle 2
	private static void suprise2(Hero h) 
	{
		Scanner sc = new Scanner(System.in);
		String answer = "";
		System.out.println("You approach to the elderwood, he welcomes you \"You look tired my child maybe I can help you with that if you can answer my question\" then asks:");
		System.out.println("Towns without houses, forests without trees, mountains without boulders and waterless seas. What am I ?");
		answer = sc.nextLine();
		if (answer.equalsIgnoreCase("map") || answer.equalsIgnoreCase("a map")) 
		{
			System.out.println("After hearing your answer, the elderwood replied: \"A wise man knows that his/her mind is the strongest weapon. May this bottle save you in a time of crisis\"\nGood luck adventurer!");
			System.out.println("You have earned a healing potion!");
			h.setPotionC(h.getPotionC() + 1);
		} 
		else // wrong answer
		{
			System.out.println("Beware adventurer, I've heard you've got strength but you mustn't forget that even it must bow before wisdom.");
			System.out.println("May this lesson guide you through your battles");
		}
	}
	
	// SET MUSIC !!!
	private static void setMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		if(musicFile1.exists() && musicFile2.exists() && musicFile3.exists() && musicFile4.exists()) // find the file
        {
            // main theme
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile1); 
            clip1 = AudioSystem.getClip();
            clip1.open(audioInput); // starts music
            clip1.loop(Clip.LOOP_CONTINUOUSLY); // loops
            clip1.stop(); // stops music
            
            // pleb fights
            audioInput = AudioSystem.getAudioInputStream(musicFile2);
            clip2 = AudioSystem.getClip();
            clip2.open(audioInput);
            clip2.loop(Clip.LOOP_CONTINUOUSLY);
            clip2.stop();
            
            // mini boss fights
            audioInput = AudioSystem.getAudioInputStream(musicFile3);
            clip3 = AudioSystem.getClip();
            clip3.open(audioInput);
            clip3.loop(Clip.LOOP_CONTINUOUSLY);
            clip3.stop();
           
            // boss fight
            audioInput = AudioSystem.getAudioInputStream(musicFile4);
            clip4 = AudioSystem.getClip();
            clip4.open(audioInput);
            clip4.loop(Clip.LOOP_CONTINUOUSLY);
            clip4.stop();
        }
        else // can't find the file
        { 
            System.out.println("Cant find music file");
        }
	}
}
