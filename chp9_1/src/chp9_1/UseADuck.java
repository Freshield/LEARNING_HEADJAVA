package chp9_1;

public class UseADuck {

	public static void main(String[] args) {
		
		Duck d = new Duck(34);
		
		System.out.println(d.size);
		
		d.setSize(42);
		
		System.out.println(d.size);

	}

}
