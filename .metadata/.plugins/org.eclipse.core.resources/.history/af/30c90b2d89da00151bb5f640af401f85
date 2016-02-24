package probuf_server;

import java.util.*;
import com.google.protobuf.InvalidProtocolBufferException;
import com.protobuf.AnimalList;

import java.lang.Runtime;
import java.io.*;

public class Server {
	
	private HashMap<String, String> map = new HashMap<String, String>() {
	    {
	    	put("0","Does it can fly?");
	    	put("1","Does it eat meat?");
	    	put("2","Does it have soft fur?");
	    	put("3","Does it run fast?");
	    	put("4","Cow");
	    	put("5","Horse");
	    	put("6","Does it has red eye?");
	    	put("7","Sheep");
	    	put("8","Rabbit");
	    	put("9","Does it is a pet?");
	    	put("10","Does it has legs?");
	    	put("11","Snake");
	    	put("12","Lion");
	    	put("13","Does it need walk everyday?");
	    	put("14","Cat");
	    	put("15","Dog");
	    	put("16","Does it eat meat?");
	    	put("17","Does it looked beautiful?");
	    	put("18","Does it drink blood?");
	    	put("19","Fly");
	    	put("20","Mosquito");
	    	put("21","Does it lives around water?");
	    	put("22","Butterfly");
	    	put("23","Dragonfly");
	    	put("24","Does it lives around water?");
	    	put("25","Does it act during the night?");
	    	put("26","Woodpecker");
	    	put("27","Bat");
	    	put("28","Does it big?");
	    	put("29","Duck");
	    	put("30","Goose");
	    }
	};

	public static void main(String[] args) {
		
		new Server().go();

	}
	
	public void go(){
		
		AnimalList.Animal.Builder builder = AnimalList.Animal.newBuilder();
		builder.setId("0");
		builder.setName("YY");
		
		AnimalList.Animal animal = builder.build();
		String buffer = animal.toString();
		System.out.println(buffer);
		byte[] buf = animal.toByteArray();
		
		
		File f = new File("buf.txt");
		try{
			
			
			FileOutputStream output = new FileOutputStream("buf.txt");
			builder.build().writeTo(output);
			output.close();
			
			
			//DataInputStream inp = new DataInputStream(new FileInputStream(new File("buf.txt")));
			byte[] getter;
			//ByteArrayOutputStream out1 = new ByteArrayOutputStream();
			//out1.write(inp.read());
			//getter = out1.toByteArray();
			FileInputStream input = new FileInputStream("buf.txt");
			
			AnimalList.Animal getanimal = AnimalList.Animal.parseFrom(input);
			//String theresult = getanimal.toString();
			System.out.println(getanimal);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
			
	}
		

}
