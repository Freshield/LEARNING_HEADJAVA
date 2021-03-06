package chp12_11;

import javax.swing.*;
import java.awt.*;

public class Animate {
	
	JFrame frame;
	int x = 1;
	int y = 1;
	int re = 55;
	int gr = 55;
	int bl = 200;
	Color blockcolor;

	public static void main(String[] args) {
		
		Animate gui = new Animate();
		gui.go();

	}
	
	public void go(){
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel drawP = new MyDrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER, drawP);
		frame.setSize(800, 500);
		frame.setVisible(true);
		
		for(int i = 0;i<124;i++,x++,y++){
			
			x++;
			drawP.repaint();
			try{
				Thread.sleep(50);
				
			}catch(Exception ex){
				
			}
			
		}
		
	}
	
	class MyDrawPanel extends JPanel{
		
		public void paintComponent(Graphics g){
			
			
			blockcolor = new Color(re,gr,bl);
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(blockcolor);
			g.fillRect(x, y, 500-x*2, 250-y*2);
			
			if((re+2) < 255){
				re += 2;
			}
			if((gr+2) < 255){
				gr += 2;
			}
			if((bl+2) < 255){
				bl += 2;
			}
			
		}
		
	}

}
