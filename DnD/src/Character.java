public class Character 
{
	protected int hp;
	protected int ad;
	protected String name;

	public Character(String name, int hp, int ad) 
	{
		this.hp = hp;
		this.ad = ad;
		this.name = name;
	}

	public int getHp() 
	{
		return hp;
	}

	public void setHp(int hp) 
	{
		this.hp = hp;
	}

	public int getAd() 
	{
		return ad;
	}

	public void setAd(int ad) 
	{
		this.ad = ad;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
}
