package chp4_1;

public class Sound {
	
	String title;
	String artist;
	
	public void setTtitle(String name)
	{
		title = name;
	}

	public void setArtist(String name)
	{
		artist = name;
	}
	
	public void playSound()
	{
		System.out.println(title + artist);
	}
	
	public static void main(String[] args) {


		Sound s1 = new Sound();
		s1.title = "t1";
		s1.artist = "a1";
		s1.playSound();
		
		

	}

}
