package assessment.Int.problems;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public List<String> reorderLines(int logFileSize, List<String> logLines) {
		List<String> numbersRows = new LinkedList<>();
		List<String> alphabeticRows = new LinkedList<>();
		PriorityQueue<Row> pqLines = new PriorityQueue<Row>((Row r1, Row r2) -> {
			int comp = r1.content.compareTo(r2.content);
			if (comp == 0) {
				return r1.identifier.compareTo(r2.identifier);
			}
			return comp;
		});
		for (String str : logLines) {
			String identifier = str.toLowerCase().substring(0, str.indexOf(' '));
			String content = str.toLowerCase().substring(str.indexOf(' ') + 1);

			if (content.matches(".*\\d+.*")) {
				numbersRows.add(str);
			} else {
				pqLines.offer(new Row(identifier, content));
			}
		}
		while (!pqLines.isEmpty()) {
			Row poll = pqLines.poll();
			alphabeticRows.add(poll.identifier + " " + poll.content);
		}
		alphabeticRows.addAll(numbersRows);
		return alphabeticRows;

	}

	// METHOD SIGNATURE ENDS
	static class Row {
		String identifier;
		String content;

		public Row(String identifier, String content) {
			this.identifier = identifier;
			this.content = content;
		}
	}
}