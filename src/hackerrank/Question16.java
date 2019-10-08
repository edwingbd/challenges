package hackerrank;

import java.util.*;

public class Question16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new TreeSet<Integer>();
		set.add(3);
		set.add((int) 3.0);
		set.add(2);
		set.add(2);
		set.add(new Integer(2));
		set.add(Integer.parseInt("2"));
		System.out.println(set);
		//print 2,3 the information is not repetead in the set or treeset.
	}

}
