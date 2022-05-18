import java.util.*;
public class Sorcerer extends Hero 
{
	int mana = 20;
	Scanner sc = new Scanner(System.in);

	public Sorcerer(String name, int hp, int ad, String skill, String type, int potionC)
	{
		super(name, hp, ad, skill, type, potionC);
	}

	// +10 hp, +ad(monster*3/2)
	public void useUltimate(Monster monster) 
	{
		printWS();
		// check if you want to use ult (1 yes, 2 no)
		String check = sc.nextLine();
		if (check.equals("1")) {
			if (this.getMana() >= 10) // enough mana
			{
				this.setHp(this.getHp() + 10);
				monster.setHp(monster.getHp() - 3 * monster.getAd() / 2);
				this.setMana(this.getMana() - 10);
				if (monster.getHp() > 0) // monster alive
				{
					System.out.println("You dealt " + (3 * monster.getAd() / 2) + " damage to the monster and its remaining health is " + monster.getHp() + ".");
					this.setHp(this.getHp() - monster.getAd());
					if (this.getHp() > 0) // hero alive
					{
						System.out.println("Your Hp is" + this.getHp() + ".");
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
			else if (this.getMana() < 10) // not enough mana
			{
				System.out.println("Not enough mana!");
			}
			this.setAd(1);
		}
	}

	// monster -hp*1/2
	public void useSpecial(Monster monster)
	{
		if (useSpecial == false) // special not used
		{
			printWSS();
			// check if you want to use special (1 yes, 2 no)
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

	public void printSorcerer() 
	{
		System.out.println("You have " + this.getHp() + " HP, " + this.getAd() + " AD, " + this.getMana() + " mana and "
				+ this.getPotionC() + " potions.");
	}

	// warning ult
	public void printWS() 
	{
		System.out.println("If you use ultimate skill, you will lose 10 mana. You have " + this.getMana()
				+ " mana left. Do you still want to use it?");
		System.out.println("1.Yes" + "\n" + "2.No");
	}

	//warning special
	public void printWSS() 
	{
		System.out.println("You can use special power only once. Do you want to use it now?");
		System.out.println("1.Yes" + "\n" + "2.No");
	}

	public int getMana()
	{
		return mana;
	}

	public void setMana(int mana)
	{
		this.mana = mana;
	}
}
