package interview;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class SolutionEncoder {
	int minimumTime(int numOfSubFiles,List<Integer> files)
	{
		if (numOfSubFiles>Math.pow(10, 6) || numOfSubFiles<2 )
			return -1;//error
		if (numOfSubFiles > files.size())
			return -1;//error
		if ( files.stream().filter(e-> e<1 || e>Math.pow(10, 6) ).count() >0  )
			return -1;
		Encoder encoder = new Encoder(numOfSubFiles, files);
		return encoder.compressFile();
	}
	class Encoder{
		int numOfSubFiles;
		List<Integer> files;
		PriorityQueue<Integer> pqEncoder;
		Encoder(int numOfSubFiles,List<Integer> files){
			this.numOfSubFiles= numOfSubFiles;
			this.files= files;
			pqEncoder = new PriorityQueue<>();
			pqEncoder.addAll(files);
		}
		int compressFile() {
			if(pqEncoder.size()<=2)
				return pqEncoder.poll()+pqEncoder.poll();
			int subCompress = pqEncoder.poll()+pqEncoder.poll();
			pqEncoder.add(subCompress);
			return subCompress+compressFile();
		}
	}
}

