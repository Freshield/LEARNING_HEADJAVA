package chp10_6;

public class TestBox {
	
	Integer i;
	int j;

	public static void main(String[] args) {
		
		TestBox t = new TestBox();
		t.i = new Integer(42);
		t.go();

	}
	
	public void go()
	{
		j = i;
		System.out.println(j);
		System.out.println(i);
	}

}
