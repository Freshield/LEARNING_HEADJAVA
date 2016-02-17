package chp12_7;

import java.awt.*;
import javax.swing.*;

public class MYGUI {
	
	JFrame frame;

	public static void main(String[] args) {
		
		MYGUI gui = new MYGUI();
		gui.go();
		

	}
	
	public void go(){
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel panel = new MyPanel();
		
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
	}
	
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g){
			
			//g.setColor(Color.orange);
			//g.fillRect(20, 50, 100, 100);
			
			Image image = new ImageIcon("test.jpg").getImage();
			g.drawImage(image, 3, 4, this);
		}
	}

}
