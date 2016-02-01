package chp6_2;

import java.util.*;

public class DomCom {
	
	private ArrayList<String> locationCells;
	private String name;
	
	
	public void setLocationCells(ArrayList<String> loc)
	{
		locationCells = loc;
		
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String checkYourself(String userInput)
	{
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		System.out.println("domcom"+name+index);
		if(index >= 0)
		{
			locationCells.remove(index);
			
			if(locationCells.isEmpty())
			{
				result = "kill";
				System.out.println("Ouch! You sunk "+name+" : ( ");
			}
			else
			{
				result = "hit";
			}
			
		}
		return result;
		
	}
	
	
	

}
