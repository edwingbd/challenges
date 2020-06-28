package assessment.Int.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RottenOrange2 {
/*In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
[[2,1,1],
 [1,1,0],
 [0,1,1]]
 output=4f
 
 
 Example 2:

Input: [[2,1,1],
        [0,1,1],
        [1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid =  {{2,1,1},{1,1,0},{0,1,1}}; //4
		System.out.println(
				Arrays.stream(grid)
			        .map(a -> String.join(" ", Arrays.toString(a)))
			            .collect(Collectors.joining(",\r")));
		System.out.println("expected 4");
		System.out.println("therotten is="+orangesRotting(grid));
		 grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}}; //-1
		System.out.println(
				Arrays.stream(grid)
			        .map(a -> String.join(" ", Arrays.toString(a)))
			            .collect(Collectors.joining(",\r")));
		System.out.println("expected -1");
		System.out.println("therotten is="+orangesRotting(grid));

		 grid =new int[][]  {{0,2}}; //0
		System.out.println(
				Arrays.stream(grid)
			        .map(a -> String.join(" ", Arrays.toString(a)))
			            .collect(Collectors.joining(",\r")));
		System.out.println("expected 0");
		System.out.println("therotten is="+orangesRotting(grid));
		
		 grid =new int[][]  {{2,1,0,2}}; //		
		System.out.println(
				Arrays.stream(grid)
			        .map(a -> String.join(" ", Arrays.toString(a)))
			            .collect(Collectors.joining(",\r")));
		System.out.println("expected 1");
		System.out.println("therotten is="+orangesRotting(grid));
		
		 grid =new int[][] {{1},{2},{1},{2}}; //1
		System.out.println(
				Arrays.stream(grid)
			        .map(a -> String.join(" ", Arrays.toString(a)))
			            .collect(Collectors.joining(",\r")));
		System.out.println("expected 1");
		System.out.println("therotten is="+orangesRotting(grid));

		
	}
	
	public static int orangesRotting(int[][] grid) {
		
		
		int result = 0;
		
        return result;
	}
}
