package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionsTester3 {
	public static void main(String[] args) {
		SolutionMoviesFlight sMoviesDuration = new SolutionMoviesFlight();
		List<Integer> movie_duration;
		int d;
		System.out.println("---------------------------Movies-Pack-------------");
		d=250;
		movie_duration = Arrays.asList(90, 85, 75, 60, 120, 150, 125);
		System.out.println("Inputs");
		System.out.println("movie_duration="+movie_duration);
		System.out.println("d="+d);
		System.out.println("result="+ sMoviesDuration.FindPairMovies(movie_duration, d));
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
		//result=sRobotClean.removeObstacle(numRows, numColumns, lot) ;
		//System.out.println("result="+result);


	}
}
