package structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class HashSetSortingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> names = new HashSet<>();
		names.add("");
		names.add("Asker"); 
		names.add("Crak"); 
		names.add("Bayliss"); 
		names.add("Mohna"); 
		names.add("Dina"); 
		System.out.println("HashSet before sorting : " + names); // Sorting HashSet using List 
		List<String> tempList = new ArrayList<String>(names); 
		Collections.sort(tempList); System.out.println("HashSet element in sorted order : " + tempList); 
		// Sorting HashSet using TreeSet 
		TreeSet<String> sorted = new TreeSet<String>(names); 
		sorted.add("Edwin");
		sorted.add("Edwin ");
		sorted.add("edwin");
		System.out.println("HashSet sorted using TreeSet : " + sorted);
		names.add("Edwin");
		names.add("Edwin ");
		names.add("edwin");
		sorted = null;
		sorted = new TreeSet<String>(names);
		System.out.println("HashSet sorted using TreeSet : " + sorted);
	}

}
