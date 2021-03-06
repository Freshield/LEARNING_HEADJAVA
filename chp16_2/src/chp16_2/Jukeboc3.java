package chp16_2;

import java.util.*;
import java.io.*;

public class Jukeboc3 {
	
	ArrayList<Song> songList = new ArrayList<Song>();

	public static void main(String[] args) {
		
		new Jukeboc3().go();

	}
	
	public void go(){
		
		getSongs();
		System.out.println(songList);
		TitleCompare titlecompare = new TitleCompare();
		Collections.sort(songList,titlecompare);
		System.out.println(songList);
		
		ArtistCompare artistCompare = new ArtistCompare();
		Collections.sort(songList, artistCompare);
		System.out.println(songList);
		
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
