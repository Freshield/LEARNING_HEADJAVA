package chp13_4;

import javax.swing.*;
import java.awt.*;

public class TextFieldTest {

	public static void main(String[] args) {
		
		TextFieldTest gui = new TextFieldTest();
		gui.go();

	}
	
public void go(){
		
		JFrame frame = new JFrame();
		
		JTextArea text = new JTextArea(10,20);
		
		JScrollPane scroller = new JScrollPane(text);
		
		text.setLineWrap(true);
		
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		text.setText("Not all who are lost are wandering");
		
		frame.getContentPane().add(BorderLayout.CENTER, scroller);
		
		
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		
	}

}
