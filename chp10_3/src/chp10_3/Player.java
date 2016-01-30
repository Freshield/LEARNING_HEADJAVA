package chp10_3;

public class Player {
	
	static int playerCount = 0;
	private String name;
	public Player(String n)
	{
		name = n;
		playerCount++;
		System.out.println(playerCount);
	}

}
