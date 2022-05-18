public class Monster extends Character
{
	private String type;
	private String award;
	
	public Monster(String name, int hp, int ad, String type, String award) 
	{
		super(name, hp, ad);
		this.type = type;
		this.award = award;
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public String getAward() 
	{
		return award;
	}

	public void setAward(String award) 
	{
		this.award = award;
	}
	
	// monster awards
	public void printMonster()
	{
		if(award.equals("End")) // dragon award
		{
			System.out.println(this.getName() + " has " + this.getHp() + " HP and " + this.getAd() + " AD. If you defeat her, you will succesfully save the village.");
		}
		else // other awards
		{
			System.out.println("This " + this.getName()+ " has " + this.getHp() + " HP and " + this.getAd() + " AD. If you can defeat it you will earn " + this.getAward() + ".");
		}
	}
}
