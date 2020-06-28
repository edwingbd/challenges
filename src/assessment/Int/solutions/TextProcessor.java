package assessment.Int.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TextProcessor {
	
	public static void main (String[] arr) {
		System.out.println("execiste text processor");
		String helpText= "Purchase order item help can't find item is too much part of purchase need fix for image item delivered too fast purchase order too big is purchases order coming? tooo big why";
		List<String> WordsToExclude = new ArrayList<String>(Arrays.asList( "help","fix","too","is","of" ));
		System.out.println("helpText"+helpText);
		System.out.println("WordsToExclude"+WordsToExclude);
		System.out.println("Result ="+ retrieveMostFrequentlyUseWords(helpText,WordsToExclude ));
	}
	
	public static List<String> retrieveMostFrequentlyUseWords(String helpText,List<String> WordsToExclude ){
		List<String> lstResult = new ArrayList<String>();
		List<String> lstText = Arrays.asList( helpText.toLowerCase().split("[^a-z]"));
		TreeMap<String,Integer> tmWords = new TreeMap<String, Integer>();
		Integer count=0;
		for(String word : lstText.stream().filter(e-> !WordsToExclude.contains(e) ).collect(Collectors.toList())  ) {
			Integer value =1+(tmWords.containsKey(word)?tmWords.get(word):0);
			tmWords.put(word, value);
			if(value>count)
				count=value;
		}
		System.out.println(tmWords);
		while(!tmWords.isEmpty() ) {
			Entry entry =tmWords.pollFirstEntry();
			if(entry.getValue() == count)
					lstResult.add((String) entry.getKey());
		}
		System.out.println(helpText);
		System.out.println(lstText);
		
		
		return lstResult;
	}
}
