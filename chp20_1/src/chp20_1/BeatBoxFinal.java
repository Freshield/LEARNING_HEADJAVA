package chp20_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.sound.midi.*;
import javax.swing.event.*;

public class BeatBoxFinal {
	
	JFrame theFrame;
	JPanel mainPanel;
	JList incomingList;
	JTextField userMessage;
	ArrayList<JCheckBox> checkboxList;
	int nextNum;
	Vector<String> listVector = new Vector<String>();
	String userName;
	ObjectOutputStream out;
	ObjectInputStream in;
	HashMap<String, boolean[]> otherSeqsMap = new HashMap<String,boolean[]>();
	
	Sequencer sequencer;
	Sequence sequence;
	Sequence mySequence = null;
	Track track;
	

	String[] instrumentNames = {"Bass Drum","Closed Hi-Hat","Open Hi-Hat",
			"Acoustic Snare","Crash Cymbal","Hand Clap","High Tom","Hi Bongo",
			"Maracas","Whistle","Low Conga","Cowbell","Vibraslap","Low-mid Tom",
			"High Agogo","Open Hi Conga"};
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

	public static void main(String[] args) {
		
		new BeatBoxFinal().startUp(args[0]);

	}
	
	public void startUp(String name){
		
		userName = name;
		
		try{
			
			Socket sock = new Socket("127.0.0.1",4242);
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			Thread remote = new Thread(new RemoteReader());
			remote.start();
			
			
		}catch(Exception ex){
			System.out.print("couldn't connect - you'll have to play alone.");
		}
		setUpMidi();
		buildGUI();
	}
	
	public class RemoteReader implements Runnable{
		
		boolean[] checkboxState = null;
		String nameToShow = null;
		Object obj = null;
		public void run(){
			
			try{
				
				while((obj = in.readObject()) != null){
					
					System.out.println("got an object from server");
					System.out.println(obj.getClass());
					String nameToShow = (String) obj;
					checkboxState = (boolean[]) in.readObject();
					otherSeqsMap.put(nameToShow, checkboxState);
					listVector.add(nameToShow);
					incomingList.setListData(listVector);
					
				}
				
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
	}
	
	public void buildGUI(){
		
		theFrame = new JFrame("Cyber BeatBox");
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		checkboxList = new ArrayList<JCheckBox>();
		
		Box buttonBox = new Box(BoxLayout.Y_AXIS);
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);

		JButton stop = new JButton("stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);

		JButton upTempo = new JButton("UpTempo");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);

		JButton dowmTempo = new JButton("DowmTempo");
		dowmTempo.addActionListener(new MyDowmTempoListener());
		buttonBox.add(dowmTempo);

		JButton sendIt = new JButton("SendIt");
		sendIt.addActionListener(new MySendItListener());
		buttonBox.add(sendIt);
		
		userMessage = new JTextField();
		buttonBox.add(userMessage);
		
		incomingList = new JList();
		incomingList.addListSelectionListener(new MyListSelectionListener());
		incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane theList = new JScrollPane(incomingList);
		buttonBox.add(theList);
		incomingList.setListData(listVector);
		
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i = 0;i<16;i++){
			nameBox.add(new Label(instrumentNames[i]));
		}
		
		background.add(BorderLayout.EAST,buttonBox);
		background.add(BorderLayout.WEST,nameBox);
		
		theFrame.getContentPane().add(background);
		GridLayout grid = new GridLayout(16, 16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER,mainPanel);
		
		for(int i = 0;i<256;i++){
			
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
			
		}
		
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setBounds(50,50,300,300);
		theFrame.pack();
		theFrame.setVisible(true);
		
		
		
	}
	
	public void setUpMidi(){
		
		try{
			
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
			
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	public class MyStartListener implements ActionListener{
		
		public void actionPerformed(ActionEvent a){
			
			buildTrackAndStart();
			
		}
	}
	
	public void buildTrackAndStart(){
		
		int[] trackList = null;
		

		setUpMidi();
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		
		for(int i = 0;i<16;i++){
			trackList = new int[16];
			
			int key = instruments[i];
			
			for(int j = 0;j<16;j++){
				
				
				JCheckBox jc = (JCheckBox) checkboxList.get(j+(16*i));
				if(jc.isSelected()){
					
					trackList[j] = key;
					
				}else{
					
					trackList[j] = 0;
				}
			}
			
			makeTracks(trackList);
			track.add(makeEvent(176,1,127,0,16));
			try{
				
				sequencer.setSequence(sequence);
				sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
				sequencer.start();
				sequencer.setTempoInBPM(120);
				
				
			}catch(Exception e){
				
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	public void makeTracks(int[] list){
		
			for(int i = 0;i<16;i++){
			
			int key = list[i];
			
			if(key != 0){
				
				track.add(makeEvent(144,9,key,100,i));
				track.add(makeEvent(128,9,key,100,i+2));
			}
			
		}
	}
	
	public MidiEvent makeEvent(int comd,int chan,int one,int two,int tick){
		
		MidiEvent event = null;
		try{
			
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a,tick);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return event;
		
	}

	public class MyStopListener implements ActionListener{
		
		public void actionPerformed(ActionEvent a){
			
			sequencer.stop();
			
		}
	}

	public class MyUpTempoListener implements ActionListener{
		
		public void actionPerformed(ActionEvent a){
			
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor*1.03));
			
		}
	}

	public class MyDowmTempoListener implements ActionListener{
		
		public void actionPerformed(ActionEvent a){

			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor* .97));
			
		}
	}

	public class MySendItListener implements ActionListener{
		
		public void actionPerformed(ActionEvent a){
			
			boolean[] checkboxState = new boolean[256];
			for(int i = 0;i<256;i++){
				JCheckBox check = (JCheckBox) checkboxList.get(i);
				if(check.isSelected()){
					checkboxState[i] = true;
				}
			}
			
			String messageToSend = null;
			
			try{
				
				out.writeObject(userName + nextNum++ + ": "+userMessage.getText());
				out.writeObject(checkboxState);
				
				
			}catch(Exception ex){
				
				System.out.println("Sorry dude. Could not send it to the server.");
			}
			userMessage.setText("");
			
		}
	}

	public class MyListSelectionListener implements ListSelectionListener{
		
		public void valueChanged(ListSelectionEvent le){
			
			if(!le.getValueIsAdjusting()){
				
				String selected = (String) incomingList.getSelectedValue();
				if(selected != null){
					
					boolean[] selectedState = (boolean[]) otherSeqsMap.get(selected);
					changeSequence(selectedState);
					sequencer.stop();
					buildTrackAndStart();
				}
			}
			
		}
	}
	
	public void changeSequence(boolean[] checkboxState){
		
		for(int i = 0;i<256;i++){
			
			JCheckBox check = (JCheckBox) checkboxList.get(i);
			if(checkboxState[i]){
				check.setSelected(true);
			}else{
				check.setSelected(false);
			}
		}
	}

}
