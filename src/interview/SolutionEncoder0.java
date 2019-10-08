package interview;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class SolutionEncoder0 {
	int minimumTime(int numOfSubFiles,List<Integer> files)
	{
		//Constraints
		if(numOfSubFiles <2 || numOfSubFiles > Math.pow(10, 6) )
			return 0;
		if (files.stream().filter(e->(e>Math.pow(10, 6)) ||(e<1) ).limit(numOfSubFiles).count() > 0 )
			return 0;
		//sort the list
		files=files.stream()
				.limit(numOfSubFiles)
				.sorted(Comparator.comparingInt(e->e))
				.limit(numOfSubFiles)
				.collect(Collectors.toList()) ;
		//create a method that execute the sum and remove the last
		return encoderFile(files);
	}
	
	int encoderFile(List<Integer> files2) {
		if (files2.size() <2 )
			return 0;
		files2.set(1, files2.get(0) +files2.get(1));
		files2.remove(0);
		return files2.get(0) + encoderFile(files2);
	}
}
