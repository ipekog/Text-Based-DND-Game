import java.util.*;
public class Rogue extends Hero 
{
	int energy = 20;
	Scanner sc = new Scanner(System.in);

	public Rogue(String name, int hp, int ad, String skill, String type, int potionC) 
	{
		super(name, hp, ad, skill, type, potionC);
	}

	// steal monster hp*1/4, attacks ad + monster ad*3/4
	public void useUltimate(Monster monster)
	{
		printWR();
		// check if you want to use ult (1 yes, 2 no)
		String check = sc.nextLine();
		if (check.equals("1")) // yes
		{
			if (energy >= 10) // have enough energy
			{
				this.setHp(Math.round(monster.getHp() / 4) + this.getHp());
				this.setAd(Math.round(3 * monster.getAd() / 4) + this.getAd());
				monster.setHp(monster.getHp() - (this.getAd() + Math.round(monster.getHp() / 4)));
				this.setEnergy(this.getEnergy() - 10);

				if (monster.getHp() > 0) // monster alive
				{
					System.out.println("You dealt " + this.getAd()
							+ " damage to the monster and its remaining health is " + monster.getHp() + ".");
					this.setHp(this.getHp() - monster.getAd());
					if (this.getHp() > 0) // hero alive
					{
						System.out.println("Your Hp is " + this.getHp());
					} 
					else if (this.getHp() <= 0) // hero dead
					{
						System.out.println("You are dead!");
						System.out.println("Please start over!");
					}
				} 
				else if (monster.getHp() <= 0) // monster dead
				{
					System.out.println("You dealt " + this.getAd() + " and " + monster.getName() + " is dead.");
				}
			} 
			else if (energy < 10) // not enough energy
			{
				System.out.println("Not enough energy!");
			}
			this.setAd(1);
		}
	}

	// monster -hp*1/2
	public void useSpecial(Monster monster)
	{
		if (useSpecial == false) // special not used
		{
			printWSR();
			// check if you want to use ult (1 yes, 2 no)
			String check = sc.nextLine();
			if (check.equals("1")) // yes
			{
				monster.setHp(monster.getHp() - Math.round(monster.getHp() / 2));
				System.out.println("You reduced the mosters HP into half and its remaining HP is " + monster.getHp() + ".");
				System.out.println("Your HP is still " + this.getHp() + ".");
				useSpecial = true;
			}
		}
		else // special already used
		{
			System.out.println("You have already used your special attack.");
		}
	}

	public void printRogue() 
	{
		System.out.println("You have " + this.getHp() + " HP, " + this.getAd() + " AD, " + this.getEnergy()
				+ " energy and " + this.getPotionC() + " potions.");
	}

	// warning ult
	public void printWR() 
	{
		System.out.println("If you use ultimate skill, you will lose 10 energy. You have " + this.getEnergy()
				+ " energy left. Do you still want to use it?");
		System.out.println("1.Yes" + "\n" + "2.No");
	}

	// warning special
	public void printWSR() 
	{
		System.out.println("You can use special power only once. Do you want to use it now?");
		System.out.println("1.Yes" + "\n" + "2.No");
	}

	public int getEnergy() 
	{
		return energy;
	}

	public void setEnergy(int energy) 
	{
		this.energy = energy;
	}
}
