package chp16_2;

public class Song {
	
	String title;
	String artist;
	String rating;
	String bpm;
	
	Song(String t,String a,String r,String b){
		
		title = t;
		artist = a;
		rating = r;
		bpm = b;
	}
	
	public String getTitle(){
		return title;
	}

	public String getArtist(){
		return artist;
	}

	public String getRating(){
		return rating;
	}

	public String getBpm(){
		return bpm;
	}
	
	public String toString(){
		return title;
	}

}
