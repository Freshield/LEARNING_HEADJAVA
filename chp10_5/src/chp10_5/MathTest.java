package chp10_5;

import java.util.*;

public class MathTest {
	
	public static void main(String[] args) {
		
		double r1 = Math.random();
		int r2 = (int) (Math.random()*5);
		int x = Math.abs(-240);
		double d = Math.abs(240.45);
		
		System.out.println(r1+" "+r2+" "+x+" "+d);
		System.out.println(Math.round(-24.8));
		System.out.println(Math.min(90876.5, 90876.49));
		System.out.println(Math.max(24, 240));
		
		int w = 32;
		ArrayList list = new ArrayList();
		list.add(w);

		System.out.println(list);
		Integer iWrap = new Integer(w);
		int unWrapped = iWrap.intValue();
		
		MathTest t = new MathTest();
		t.doNumsNewWay();
		
		Integer i = new Integer(5);
		System.out.println(i);
		int yy = i;
		System.out.println(yy);
		

	}

	public void doNumsNewWay()
	{
		ArrayList<Integer> listofNumbers = new ArrayList<Integer>();
		listofNumbers.add(3);
		int num = listofNumbers.get(0);
		System.out.println(num);
	}


}
