package chp10_8;

import java.util.*;

public class TestFormats {

	public static void main(String[] args) {
		
		String s = String.format("%,d", 1000000000);
		System.out.println(s);
		System.out.println(String.format("I have %.2f, bugs to fix", 476578.09876));
		System.out.println(String.format("%,6.1f", 42.000));
		System.out.println(String.format("%c", 42));
		
		int one = 42;
		double two = 1234567890.23423532;
		Date today = new Date();
		System.out.println(String.format("The rank is %,d out of %,.2f", one,two));
		System.out.println(String.format("%tc", new Date()));
		System.out.println(String.format("%tr", new Date()));
		System.out.println(String.format("%tA, %tB, %td", today,today,today));
		System.out.println(String.format("%tA, %<tB %<td", today));
		

	}

}
