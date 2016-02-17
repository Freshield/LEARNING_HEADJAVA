package chp12_9;

import javax.sound.midi.*;
import java.awt.*;
import javax.swing.*;

public class MiniMusicPlayer2{
	
	static JFrame f = new JFrame("My First Music Video");
	static MyDrawPanel ml;

	public static void main(String[] args) {
		
		MiniMusicPlayer2 mini = new MiniMusicPlayer2();
		mini.go();
		

	}
	
	public void setUpGui(){
		
		ml = new MyDrawPanel();
		//f.setContentPane(ml);
		//f.setBounds(30, 30, 300, 300);
		f.getContentPane().add(BorderLayout.CENTER, ml);
		f.setSize(300, 300);
		f.setVisible(true);
	}
	
	public void go(){
		
		setUpGui();

		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			int[] eventsIWant = {127};
			sequencer.addControllerEventListener(ml, eventsIWant);
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			int r = 0;
			for(int i = 0;i<61;i++){
				
				r = (int)((Math.random()*50)+1);
				track.add(makeEvent(144, 1, r, 100, i));
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, r, 100, i+2));
				
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			
			
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
	}
	

	public static MidiEvent makeEvent(int comd,int chan,int one, int two, int tick){
		
		MidiEvent event = null;
		try{
			
			ShortMessage a = new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event = new MidiEvent(a, tick);
		}catch(Exception e){
			
		}
		return event;
		
	}
	
	class MyDrawPanel extends JPanel implements ControllerEventListener{
		
		boolean msg = false;
		
		public void controlChange(ShortMessage event){
			
			msg = true;
			repaint();
		}
		
		public void paintComponent(Graphics g){
			
			if(msg){
				
				Graphics2D g2 = (Graphics2D) g;
				
				int r = (int) (Math.random()*255);
				int gr = (int) (Math.random()*255);
				int b = (int) (Math.random()*255);
				
				g2.setColor(new Color(r,gr,b));
				
				int ht = (int)((Math.random()*120)+10);
				int wt = (int)((Math.random()*120)+10);
				int x = (int)((Math.random()*40)+10);
				int y = (int)((Math.random()*40)+10);
				
				g2.fillRect(x, y, wt, ht);
				msg = false;
				
				
				
				
			}
		}
	}
	
	

}
