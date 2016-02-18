package chp15_1;

import java.io.*;
import java.net.*;

public class DailAdviceServer {
	
	String[] adviceList = {"take smaller bites","go for the tight jeans.","one word:inappropriate",
			"just for today","you might want to rethink that haircut"
	};
	
	public void go(){
		
		try{
			
			ServerSocket serverSock = new ServerSocket(4242);
			
			while(true){
				
				Socket sock = serverSock.accept();
				
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
				
			}
			
			
			
		}catch(IOException ex){
			
			ex.printStackTrace();
		}
	}
	
	private String getAdvice(){
		
		int random = (int)(Math.random()*adviceList.length);
		return adviceList[random];
	}

	public static void main(String[] args) {
		
		DailAdviceServer server = new DailAdviceServer();
		server.go();

	}

}
