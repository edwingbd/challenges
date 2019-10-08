package concepts;


class Eagle implements Animal, Bird {
	public void eat() {
		System.out.println("Eats reptiles and amphibians.");
	}
	public void sound() {
		System.out.println("Has a high-pitched whistling sound.");
	}
	public void fly() {
		System.out.println("Flies up to 10,000 feet.");
	}
	public void poposear() {
		System.out.println("this id a method in eagle but there ir another from the interface");
		//this.poposear();
	}
}

interface Animal {
	public void eat();
	public void sound();
	default void poposear() {
		System.out.println("this id a default method");
	}
}

interface Bird {
	int numberOfLegs = 2;
	String outerCovering = "feather";

	public void fly();
}