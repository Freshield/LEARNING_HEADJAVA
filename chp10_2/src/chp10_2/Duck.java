package chp10_2;

public class Duck {
	
	private int size;
	private static int duckCount = 0;
	
	public Duck()
	{
		size = 24;
		duckCount ++;
		System.out.println(duckCount);
	}
	
	public void setSize(int s)
	{
		size = s;
	}
	
	public int getSize()
	{
		return size;
	}

}
