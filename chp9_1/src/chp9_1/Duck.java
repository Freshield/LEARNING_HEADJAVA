package chp9_1;

public class Duck {
	int size;
	
	public Duck()
	{
		size = 34;
		System.out.println("size is "+size);
	}
	public Duck(int ducksize)
	{
		size = ducksize;
		System.out.println("size is "+size);
	}
	
	public void setSize(int newSize)
	{
		size = newSize;
	}

}
