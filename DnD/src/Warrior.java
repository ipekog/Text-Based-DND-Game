import java.util.*;
public class Warrior extends Hero 
{
	int stamina = 20;
	Scanner sc = new Scanner(System.in);

	public Warrior(String name, int hp, int ad, String skill, String type, int potionC) 
	{
		super(name, hp, ad, skill, type, potionC);
	}

	// ad*10 (monster won't attack)
	public void useUltimate(Monster monster) 
	{
		printWW();
		// check if you want to use special (1 yes, 2 no)
		String check = sc.nextLine();
		if (check.equals("1")) 
		{
			if (this.getStamina() >= 10) // enough stamina
			{
				this.setAd(this.getAd() * 10);
				monster.setHp(monster.getHp() - this.getAd());
				this.setStamina(this.getStamina() - 10);
				if (monster.getHp() > 0) // monster alive
				{
					System.out.println("You dealt " + this.getAd() + " damage to the monster and its remaining health is " + monster.getHp() + ".");
				} 
				else if (monster.getHp() <= 0) // monster dead
				{
					System.out.println("You dealt " + this.getAd() + " damage and " + monster.getName() + " is dead.");
				}
			} 
			else if (this.getStamina() < 10) // not enough stamina
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
			printWSW();
			// check if you want to use special (1 yes, 2 no)
			String c = sc.nextLine();
			if (c.equals("1")) // yes
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

	public void printWarrior() 
	{
		System.out.println("You have " + this.getHp() + " HP, " + this.getAd() + " AD, " + this.getStamina()
				+ " stamina and " + this.getPotionC() + " potions.");
	}

	// warning ult
	public void printWW() 
	{
		System.out.println("If you use ultimate skill, you will lose 10 stamina. You have " + this.getStamina()
				+ " stamina left. Do you still want to use it?");
		System.out.println("1.Yes" + "\n" + "2.No");
	}

	// warning special
	public void printWSW() 
	{
		System.out.println("You can use special power only once. Do you want to use it now?");
		System.out.println("1.Yes" + "\n" + "2.No");
	}

	public int getStamina()
	{
		return stamina;
	}

	public void setStamina(int stamina) 
	{
		this.stamina = stamina;
	}
}
