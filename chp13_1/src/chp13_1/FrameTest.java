package chp13_1;

import javax.swing.*;

import java.awt.*;

public class FrameTest {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton();
		
		frame.getContentPane().add(BorderLayout.EAST, button);
		
		frame.setSize(500, 500);
		
		frame.setVisible(true);

	}

}
