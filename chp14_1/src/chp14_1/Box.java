package chp14_1;

import java.io.*;

public class Box implements Serializable{
	
	private int width;
	
	private int height;
	
	transient private Duck duck = new Duck();

	public static void main(String[] args) {
		
		Box myBox = new Box();
		myBox.setHeight(20);
		myBox.setWidth(50);
		
		try{
			
			FileOutputStream fs = new FileOutputStream("foo.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(myBox);
			os.close();
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		
		
		
		
	}
	
	public void setWidth(int w){
		
		width = w;
	}
	public void setHeight(int h){
		
		height = h;
	}
	
	

}

