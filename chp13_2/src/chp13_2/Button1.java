package chp13_2;

import javax.swing.*;
import java.awt.*;

public class Button1 {
	
	public void go(){
		
		JFrame frame = new JFrame();
		//JButton button = new JButton("Click This...");
		//Font bigFont = new Font("serif",Font.BOLD,28);
		//button.setFont(bigFont);
		
		JButton east = new JButton("EAST");
		JButton west = new JButton("WEST");
		JButton north = new JButton("NORTH");
		JButton south = new JButton("SOUTH");
		JButton center = new JButton("CENTER");
		
		
		frame.getContentPane().add(BorderLayout.NORTH, north);
		frame.getContentPane().add(BorderLayout.SOUTH, south);
		frame.getContentPane().add(BorderLayout.WEST, west);
		frame.getContentPane().add(BorderLayout.EAST, east);
		frame.getContentPane().add(BorderLayout.CENTER, center);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		
		
	}

	public static void main(String[] args) {
		
		Button1 gui = new Button1();
		gui.go();

	}

}
