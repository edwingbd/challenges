package hackerrank;

import java.util.*;

public class Question20 {
	public static void addPI(ArrayList<Double> list ) {
		list.add(Math.PI);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> dList = new ArrayList<>();
		ArrayList<Number> numList = new ArrayList<>();
		addPI(dList);
		addPI(numList);
		// error because you can call the addpi with a list of number
		//The method addPI(ArrayList<Double>) in the type Question20 is not applicable for the arguments (ArrayList<Number>)
		System.out.println( dList.toString() );
		System.out.println( numList.toString());
	}

}
