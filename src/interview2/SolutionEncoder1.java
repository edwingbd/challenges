package interview2;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class SolutionEncoder1 {
	int minimumTime(int numOfSubFiles,List<Integer> files)
	{
		//constraints
		if(numOfSubFiles < 2 || numOfSubFiles>=Math.pow(10, 6))
			return 0;
		if(files.stream().filter(e->e > Math.pow(10, 6) || e<1).count() >1 )
			return 0;
		if(numOfSubFiles < files.size() || numOfSubFiles <0 )
			return 0;
		PriorityQueue<Integer> pqFilesTime =new PriorityQueue<Integer>();
		pqFilesTime.addAll(files.stream().limit(numOfSubFiles).collect(Collectors.toList()) );
		return encoder(pqFilesTime) ;
	}
	int encoder(PriorityQueue<Integer> pqFiles ) {
		if(pqFiles.size()<=2)
			return pqFiles.poll()+pqFiles.poll();
		int timeEncode = pqFiles.poll()+pqFiles.poll();
		pqFiles.add(timeEncode);
		return timeEncode + encoder(pqFiles);
	}
}
