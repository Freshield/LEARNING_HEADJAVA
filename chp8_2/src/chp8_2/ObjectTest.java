package chp8_2;

public class ObjectTest {

	public static void main(String[] args) {
		Dog a = new Dog();
		Cat c = new Cat();
		
		if(a.equals(c))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		
		System.out.println(c.getClass());
		
		System.out.println(c.hashCode());
		
		System.out.println(c.toString());

	}

}

class Cat
{
	
}
class Dog
{
	
}