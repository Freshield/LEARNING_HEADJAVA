package chp15_6;

public class TestSync implements Runnable{
	
	private int balance;
	
	public void run(){
		
		for(int i = 0;i<50;i++){
			
			increment();
			System.out.println(Thread.currentThread().getName()+" balance is "+balance);
		}
	}
	
	public void increment(){

		synchronized(this){
		int i = balance;

		balance = i + 1;
		}

	}

}
