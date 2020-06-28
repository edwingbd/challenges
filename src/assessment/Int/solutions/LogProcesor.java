package assessment.Int.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LogProcesor {

	public static void main(String[] args) {
		System.out.println("log file");
		int logFileSize=5;
		List<String> logLines = new ArrayList<String>(Arrays.asList("a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo")) ;
		
		System.out.println("logFileSize"+logFileSize);
		System.out.println("logLines"+logLines);
		System.out.println("result"+ reorderLines(logFileSize, logLines) );
	}

	private static List<String> reorderLines(int logFileSize, List<String> logLines) {
		List<String> numericRows = new LinkedList<String>();
		List<String> alphabeticRows = new LinkedList<String>();
		PriorityQueue<Row> pqRows = new PriorityQueue<Row>(new Comparator<Row>() {
			@Override
			public int compare(Row o1,Row o2) {
				int comp = o1.content.compareTo(o2.content);
				if(comp==0) {
					return o1.identifier.compareTo(o2.identifier);
				}
				return comp;
			}
		});
		for(String str:logLines) {
			String identifier = str.substring(0,str.indexOf(' ') );
			String content = str.substring(str.indexOf(' ')+1 );
			if(content.matches(".*\\d+.*")) {
				numericRows.add(str);
			}else {
				pqRows.offer(new Row(identifier, content));
			}
		}
		while(!pqRows.isEmpty()) {
			Row poll = pqRows.poll();
			alphabeticRows.add(poll.identifier+" "+poll.content);
		}
		alphabeticRows.addAll(numericRows);
		
		return alphabeticRows;
	}
	
	static class Row{
		String identifier;
		String content;
		public Row(String identifier,String content) {
			this.identifier=identifier;
			this.content=content;
		}
	}
}
