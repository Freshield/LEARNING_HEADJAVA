package chp18_2;

import javax.sound.midi.*;
import java.io.*;
import java.nio.charset.MalformedInputException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiniMusicService implements Service{
	
	MyDrawPanel myPanel;
	
	public JPanel getGuiPanel(){
		JPanel mainPanel = new JPanel();
		myPanel = new MyDrawPanel();
		JButton playItButton = new JButton("Play_it");
		playItButton.addActionListener(new PlayItListener());
		mainPanel.add(myPanel);
		mainPanel.add(playItButton);
		return mainPanel;
	}
	
	public class MyDrawPanel extends JPanel{
		
		
		public void paintComponent(Graphics g){
			
			//g.setColor(Color.orange);
			
			//g.fillRect(20, 50, 100, 100);
			
			int red = getRandom();
			int green = getRandom();
			int blue = getRandom();
			Color startColor = new Color(red,green,blue);
			
			red = getRandom();
			green = getRandom();
			blue = getRandom();
			Color endColor = new Color(red,green,blue);
			
			Graphics2D g2d = (Graphics2D) g;
			
			GradientPaint gradient = new GradientPaint(70,70,startColor,150,150,endColor);
			
			g2d.setPaint(gradient);
			
			g2d.fillOval(70, 70, 100, 100);
			
			
		}
		
		public int getRandom(){
			
			return (int) (Math.random()*255);
		}

	}

	public class PlayItListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			myPanel.repaint();
		}
	}


}
