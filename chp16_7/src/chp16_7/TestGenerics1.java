package chp16_7;

import java.util.*;

public class TestGenerics1 {

	public static void main(String[] args) {
		new TestGenerics1().go();

	}
	
	public void go(){
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Dog());
		
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());
		dogs.add(new Dog());
		
		//Animal[] animals = {new Dog(),new Cat(),new Dog()};
		//Dog[] dogs = {new Dog(),new Dog(),new Dog()};
		takeAnimals(animals);
		System.out.println("\n");
		takeAnimals(dogs);
		
	}
	
	public void takeAnimals(ArrayList<? extends Animal> animals){
		for(Animal a:animals){
			a.eat();
		}
	}

}
