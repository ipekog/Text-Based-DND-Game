import java.util.*;
public class Hero extends Character 
{
	protected String skill;
	protected String type;
	protected int potionC;
	protected boolean useSpecial;
	ArrayList<String> teases = new ArrayList<String>();

	public Hero(String name, int hp, int ad, String skill, String type, int potionC) 
	{
		super(name, hp, ad);
		this.skill = skill;
		this.type = type;
		this.potionC = potionC;
		useSpecial = false;
	}

	public void useAttack(Monster monster) 
	{
		monster.setHp(monster.getHp() - this.getAd()); // hero attacks monster

		if (monster.getHp() > 0) // monster alive
		{
			System.out.println("You dealt " + this.getAd() + " damage to the monster and its remaining health is " + monster.getHp() + ".");
			this.setHp(this.getHp() - monster.getAd()); // monster attacks hero
			if (this.getHp() > 0) // hero alive
			{
				System.out.println("Your Hp is " + this.getHp() + ".");
			} 
			else if (this.getHp() <= 0) // hero dead
			{
				System.out.println("You are dead!");
				System.out.println("Please start over!");
			}
		} 
		else if (monster.getHp() < 0) // monster dead
		{
			System.out.println("You dealt " + this.getAd() + " and " + monster.getName() + " is dead.");
		}
	}

	public void usePotion() 
	{
		if (potionC > 0) // have potion
		{
			this.setHp(this.getHp() + 4);
			potionC--;
			System.out.println("You drank a potion, your HP is " + hp + ". Now you have " + potionC + " potions.");
		} 
		else // no potion
		{
			System.out.println("Out of potions.");
		}
	}

	public void tease() 
	{
		teases.add(0, ("Oh, you are approaching me?"));
		teases.add(1, ("My power level is over 9000!"));
		teases.add(2, ("Come fight me!"));
		teases.add(3, ("I will have order!"));
		teases.add(4, ("If you surrender now, I promise I'll be gentle."));

		Random r = new Random(); // randomly pick one
		int low = 0;
		int high = 5;
		int result = r.nextInt(high - low) + low;

		System.out.println(teases.get(result));
	}

	public String getSkill() 
	{
		return skill;
	}

	public void setSkill(String skill) 
	{
		this.skill = skill;
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public int getPotionC() 
	{
		return potionC;
	}

	public void setPotionC(int potionC) 
	{
		this.potionC = potionC;
	}
}
