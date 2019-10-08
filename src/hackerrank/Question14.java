package hackerrank;
import java.util.*;

public class Question14 {
	public static void main(String args[]) {
		List<String> list1 = new ArrayList<>();
		list1.add("foo");
		List<String> list2 = list1;
		List<String> list3 = new ArrayList<>(list2);
		list1.clear();
		list2.add("bar");
		list3.add("baz");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		
//because l2 is a reference to l1 and l3 is a copy in a moment  it will print:
//[bar]
//[bar]
//[foo, baz]
		
	}
}
