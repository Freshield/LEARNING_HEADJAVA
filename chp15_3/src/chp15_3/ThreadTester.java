package chp15_3;

public class ThreadTester {

	public static void main(String[] args) {
		
		Runnable threadJob = new MyRunnalbe();
		Thread myThread = new Thread(threadJob);
		
		myThread.start();
		
		System.out.println("back in main");
		System.out.println("back in main");
		System.out.println("back in main");
		System.out.println("back in main");
		System.out.println("back in main");
		System.out.println("back in main");
		System.out.println("back in main");
		System.out.println("back in main");
		
		

	}

}
