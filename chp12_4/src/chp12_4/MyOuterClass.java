package chp12_4;

public class MyOuterClass {
	
	private int x = 0;
	
	MyInnerClass inner = new MyInnerClass();

	public static void main(String[] args) {
		
		MyOuterClass c = new MyOuterClass();
		
		System.out.println(c.getter());

		c.inner.go();
		

		System.out.println(c.getter());
		
		
		
		
		
		

	}
	
	public int getter(){
		
		return x;
	}
	
	public void doStuff(){
		
		inner.go();
	}
	
	class MyInnerClass{
		
		void go(){
			
			x = 42;
			
		}
		
	}

}
