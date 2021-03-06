package chp16_4;

import java.util.*;
import java.io.*;

public class Jukebox6 {
	
	ArrayList<Song> songList = new ArrayList<Song>();

	public static void main(String[] args) {
		
		new Jukebox6().go();

	}
	
	public void go(){
		
		getSongs();
		System.out.println(songList);
		TitleCompare titlecompare = new TitleCompare();
		ArtistCompare artistcompare = new ArtistCompare();
		Collections.sort(songList,titlecompare);
		System.out.println(songList);

		HashSet<Song> songSet = new HashSet<Song>();
		songSet.addAll(songList);
		System.out.println(songSet);
		
		TreeSet<Song> songSetT = new TreeSet<>(artistcompare);
		songSetT.addAll(songList);
		System.out.println(songSetT);
		

		
	}

	public class TitleCompare implements Comparator<Song>{
		
		public int compare(Song one,Song two){
			return one.getTitle().compareTo(two.getTitle());
		}
	}
	public class ArtistCompare implements Comparator<Song>{
		
		public int compare(Song one,Song two){
			return one.getArtist().compareTo(two.getArtist());
		}
	}
	
	public void getSongs(){
		
		try{
			
			File file = new File("SongList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null){
				addSong(line);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void addSong(String lineToParse){
		
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
		songList.add(nextSong);
	}

}