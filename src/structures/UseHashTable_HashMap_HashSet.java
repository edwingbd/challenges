package structures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.stream.Collectors;

public class UseHashTable_HashMap_HashSet {

	public static void main(String[] args) {
		Hashtable<Integer, String> hashTable = new Hashtable<Integer, String>();
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		HashSet<Integer> hashSet = new HashSet<Integer>();
//		hashTable.put(null, null); error exeption
//		hashTable.put(null, "null"); error exeption
		// hashTable.put(100, null); error exeption
		hashMap.put(null, null); // accept null value, null key
		hashMap.put(null, "texto"); //
		hashMap.put(100, null);
		hashSet.add(null);
		for (int i = 1; i < 10; i++) {
			hashTable.put(i*2, "numer #" + i);
			hashTable.put(i*2, "numer #" + i * 2);
			hashTable.put(i*2, "" + Character.toString((char) (i + 60)));

			hashMap.put(i, "numer #" + i);
			hashMap.put(i, "char" + Character.toChars(i + 60).toString());
			hashMap.put(i, "" + i * 3);
			hashSet.add(i);
		}

		System.out.println("hashTable"+hashTable);
		System.out.println("hashMap"+hashMap);
		System.out.println("hashSet"+hashSet);
		hashMap.put(null, "100");// just one with null
		System.out.println(hashSet.remove(null));
		System.out.println(hashSet.remove(null));
		hashSet.add(null);
		hashSet.addAll(hashMap.keySet());
		hashSet.addAll(hashTable.keySet());
		System.out.println("hashMap"+hashMap);
		System.out.println("hashSet"+hashSet);
		hashSet.addAll(hashMap.values().stream().map(e->Integer.getInteger(e)).collect(Collectors.toList())  );
		hashSet.addAll(hashTable.values().stream().map(e->Integer.getInteger(e)).collect(Collectors.toList())  );
		System.out.println("hashSet"+hashSet);
		/// tray to print sorted
		Iterator<Integer> iteHashSet = hashSet.iterator();
		System.out.println("hashSet"+hashSet);
		System.out.println("iteHashSet"+iteHashSet);

		while(iteHashSet.hasNext() ) {
			System.out.println( iteHashSet.next());
		}
		System.out.println("hashSet"+hashSet);
		System.out.println("iteHashSet"+iteHashSet);

		
	}
}
