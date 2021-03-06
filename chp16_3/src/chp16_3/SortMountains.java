package chp16_3;

import java.util.*;

public class SortMountains {
	
	LinkedList<Mountain> mtn = new LinkedList<Mountain>();
	
	class NameCompare implements Comparator<Mountain>{
		
		public int compare(Mountain one,Mountain two){
			return one.getName().compareTo(two.getName());
		}
	}
	
	class HeightCompare implements Comparator<Mountain>{
		
		public int compare(Mountain one,Mountain two){
			return two.getHeight().compareTo(one.getHeight());
		}
	}

	public static void main(String[] args) {
		new SortMountains().go();

	}
	
	public void go(){
		
		mtn.add(new Mountain("longs",14255));
		mtn.add(new Mountain("elbert",14433));
		mtn.add(new Mountain("maroon",14156));
		mtn.add(new Mountain("castle",14265));
		
		System.out.println("as entered:\n"+mtn);
		
		HeightCompare hc = new HeightCompare();
		NameCompare nc = new NameCompare();
		Collections.sort(mtn, nc);
		System.out.println("by name:\n"+mtn);
		Collections.sort(mtn, hc);
		System.out.println("by height:\n"+mtn);
		
	}
	
	public class Mountain{
		
		private String Name;
		private Integer Height;
		
		public Mountain(String n,Integer h){
			
			Name = n;
			Height = h;
			
		}
		
		public String getName(){
			return Name;
		}
		public Integer getHeight(){
			return Height;
		}
		public String toString(){
			return Name+" "+Height;
		}
		
	}

}
