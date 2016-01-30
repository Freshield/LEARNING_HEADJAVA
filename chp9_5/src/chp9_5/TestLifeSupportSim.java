package chp9_5;

import java.util.*;

public class TestLifeSupportSim {

	public static void main(String[] args) {
		
		ArrayList<SimUnit> aList = new ArrayList<SimUnit>();
		V2Radiator v2 = new V2Radiator(aList);
		V3Radiator v3 = new V3Radiator(aList);
		for(int z=0;z<20;z++)
		{
			RetentionBot ret = new RetentionBot(aList);
		}
		
		

	}

}


class V2Radiator
{
	public V2Radiator(ArrayList<SimUnit> list)
	{
		System.out.println("new V2Radiator");
		for(int x=0;x<5;x++)
		{
			list.add(new SimUnit("V2Radiator"));
		}
		System.out.println("new V2Radiator");
	}
	public V2Radiator()
	{
		
	}
}

class V3Radiator extends V2Radiator
{
	public V3Radiator(ArrayList<SimUnit> lglist)
	{
		//super(lglist);
		System.out.println("new V3Radiator");
		for(int g=0;g<10;g++)
		{
			lglist.add(new SimUnit("V3Radiator"));
		}
		System.out.println("new V3Radiator");
	}
}

class RetentionBot
{
	public RetentionBot(ArrayList<SimUnit> rlist)
	{
		System.out.println("new RetentionBot");
		rlist.add(new SimUnit("Retention"));
		System.out.println("new RetentionBot");
	}
}

class SimUnit
{
	String botType;
	
	SimUnit(String type)
	{
		botType = type;
		System.out.println("new SimUnit");
	}
	
	int powerUse()
	{
		if("Retention".equals(botType))
		{
			return 2;
		}
		else
		{
			return 4;
		}
	}
}






