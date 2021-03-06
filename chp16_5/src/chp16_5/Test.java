package chp16_5;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		Test test = new Test();
		test.go();
		
	}
	
	public void go(){

		Book b1 = new Book("how");
		Book b2 = new Book("remix");
		Book b3 = new Book("fingding");
		
		BookCompare bCompare = new BookCompare();
		TreeSet<Book> tree = new TreeSet<>(bCompare);
		tree.add(b1);
		tree.add(b2);
		tree.add(b3);
		System.out.println(tree);

	}
	
	public class BookCompare implements Comparator<Book>{
		
		public int compare(Book one,Book two){
			return one.title.compareTo(two.title);
		}
	}

}
