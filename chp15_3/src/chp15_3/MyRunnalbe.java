package chp15_3;

public class MyRunnalbe implements Runnable{
	
	public void run(){
		go();
	}
	
	public void go(){
		doMore();
	}
	
	public void doMore(){
		
		System.out.println("top o' the statck");
	}

}
