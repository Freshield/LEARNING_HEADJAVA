package chp15_8;

public class ThreadOne implements Runnable{
	
	Accum a = Accum.getAccum();
	
	public void run(){
		
		for(int i = 0;i<98;i++){
			
			a.updateCounter(1000);
			try{
				
				Thread.sleep(50);
				
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		System.out.println("one "+a.getCount());
	}

}