package chp12_6;

import javax.swing.*;
import java.awt.*;

public class SimpoleAnimation {
	
	int x = 70;
	int y = 70;

	public static void main(String[] args) {
		
		SimpoleAnimation gui = new SimpoleAnimation();
		gui.go();

	}
	
	public void go(){
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanle drawPanel = new MyDrawPanle();
		
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		for(int i = 0;i<(drawPanel.getHeight()-110);i++){
			
			x++;
			y++;
			
			drawPanel.repaint();
			
			try{
				Thread.sleep(30);
				
			}catch(Exception ex){
				
			}
		}
	}
	
	class MyDrawPanle extends JPanel{
		
		public void paintComponent(Graphics g){
			
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			g.setColor(Color.green);
			g.fillOval(x, y, 40, 40);
		}
		
	}

}
