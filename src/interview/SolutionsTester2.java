package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionsTester2 {
	public static void main(String[] args) {
		SolutionEncoder sEncoder = new SolutionEncoder();
		int numOfSubFiles;
		List<Integer> files;
		int result;
		System.out.println("---------------------------Encoder-------------");
		numOfSubFiles=4;
		files = Arrays.asList(4,8,6,12);
		System.out.println("Inputs");
		System.out.println("numOfSubFiles="+numOfSubFiles);
		System.out.println("files="+files);
		result=sEncoder.minimumTime(numOfSubFiles, files);
		System.out.println("result="+result);
		System.out.println("----------------------------RobotClean------------");
		SolutionRobotClean sRobotClean = new SolutionRobotClean();
		int numRows=3;
		int numColumns=3;
		List<List<Integer>> lot = new ArrayList<>();
		lot.add(new ArrayList<>(Arrays.asList(1,0,0)));
		lot.add(new ArrayList<>(Arrays.asList(1,0,0)));
		lot.add(new ArrayList<>(Arrays.asList(1,9,1)));
		System.out.println("Inputs");
		System.out.println("numRows="+numRows);
		System.out.println("numColumns="+numColumns);
		System.out.println("lot="+lot);
		result=sRobotClean.removeObstacle(numRows, numColumns, lot) ;
		System.out.println("result="+result);
//		input 
//		numRows=3
//		numColumns=3
//		lot=[[1,0,0],[1,0,0],[1,9,1]]
//
//		output = 3

	}
}
