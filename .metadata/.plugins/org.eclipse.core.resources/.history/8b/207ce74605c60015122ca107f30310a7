package chp6_1;
import java.util.ArrayList;

public class DotComTestDrive {

	public static void main(String[] args) {
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		
		DotCom dot = new DotCom();
		int randomNum = (int)(Math.random()*5);
		int randomNum1 = randomNum + 1;
		int randomNum2 = randomNum + 2;
		String Srandom0 = Integer.toString(randomNum);
		String Srandom1 = Integer.toString(randomNum1);
		String Srandom2 = Integer.toString(randomNum2);
		ArrayList<String> locations = new ArrayList<String>();
		locations.add(Srandom0);
		locations.add(Srandom1);
		locations.add(Srandom2);
		
		dot.setLocationCells(locations);
		boolean isAlive = true;
		
		
		while(isAlive == true)
		{
			String guess = helper.getUserInput("enter a number");
			String result = dot.checkYourself(guess);
			numOfGuesses++;
			
			if(result.equals("kill"))
			{
				isAlive = false;
				System.out.println("You took "+numOfGuesses + " guesses");
			}
			
		}

	}

}
