package chp10_7;

public class StringTest {

	public static void main(String[] args) {
		
		String s = "2";
		int x = Integer.parseInt(s);
		double d = Double.parseDouble(s);
		boolean b = new Boolean("true").booleanValue();
		
		System.out.println(s);
		System.out.println(x);
		System.out.println(d);
		System.out.println(b);
		
		double e = 42.5;
		String doubleString = ""+e;
		String Doublestring = Double.toString(e);

		System.out.println(e);
		System.out.println(doubleString);
		System.out.println(Doublestring);

	}

}
