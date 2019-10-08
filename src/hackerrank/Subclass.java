package hackerrank;

public class Subclass extends Outer.Inner {
	public Subclass(Outer outer){
		// THIS NEED TO BE IN BECAUSE NEED AND A CONSTRUCTOR.
		outer.super();
		value ="hola";
	}
	
	public String value;
}
