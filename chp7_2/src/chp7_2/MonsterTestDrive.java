package chp7_2;

public class MonsterTestDrive {
	

	public static void main(String[] args) {
		
		Monster [] ma = new Monster[3];
		
		ma[0] = new Vampire();
		ma[1] = new Dragon();
		ma[2] = new Monster();
		
		
		
		if(ma[1] instanceof Vampire)
		{
			Vampire v = (Vampire) ma[1];
			v.test();
		}
		
		for(int x = 0; x<3;x++)
		{
			ma[x].frighten(x);
		}
		
		//ma[0].test();
		
		

	}

}

class Monster
{
	boolean frighten(int d)
	{
		System.out.println("arrrgh");
		return false;
	}
}

class Vampire extends Monster
{
	boolean frighten(int x)
	{
		System.out.println("a bite?");
		return true;
	}
	void test()
	{
		System.out.println("233");
	}
}


class Dragon extends Monster
{
	boolean frighten(int degree)
	{
		System.out.println("breath fire");
		return true;
	}
	
}
