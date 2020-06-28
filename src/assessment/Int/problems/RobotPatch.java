package assessment.Int.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobotPatch {
	/**
	 * --- Robot Patch 2 you are in charge of preparing a rencelty purchased lot fo
	 * ine of amazons's new building the lot is covered with trenches and has a
	 * single obstacle that need to be taked down before the foundation can be
	 * prpared for the building the demolition robor must remove the obstacle
	 * berfoer progress can be made on the building
	 * 
	 * write an alortighm to determinae the minimum distance requierd for the
	 * demolition robot to remove the obstacle.
	 * 
	 * assumptions: -the los tis flat, except for trenches, and can be represented
	 * as a two-dimensional grid. -The demolition robot must start from the top-keft
	 * corner of the lot, which is always flat, and can move one block up,down,left,
	 * or right at a time. - the demolition robot cannot enter trenches and cannot
	 * leave the lot. the flat areas are represente as 1 areas whit trhenches are
	 * repeste by 0 and the obstacle is represte by 9
	 * 
	 * Input: The input to the function/method consist if three arguemnts: -
	 * NumbRows an integer represting the number of rows - num Columns an integer
	 * representing the number of columns lots, - lot representeing the two
	 * dimensional grid of integers.
	 * 
	 * Output: return an intere represitn the minimum distance traversed to remvoe
	 * the obstacle else return -1
	 * 
	 * Constrain 1<= numRows, numColumns <= 1000
	 * 
	 * Example numRows 3; numColumns = 3; lot = [[1,0,0] [1,0,0] [1,9,1]] output 3
	 * Explanation Starting From the top lef corner , the demolition robot traversed
	 * the cells (0,0)->(1,0)->(2,0)->(2,1) the robot traversed the total distance 3
	 * to remove the obstacle so the output is 3
	 */
	public static void main(String[] args) {
		int numRows = 3;
		int numColumns = 3;
		List<List<Integer>> lot = new ArrayList<>();
		lot.add(new ArrayList<>(Arrays.asList(1, 0, 0)));
		lot.add(new ArrayList<>(Arrays.asList(1, 0, 0)));
		lot.add(new ArrayList<>(Arrays.asList(1, 9, 1)));
		System.out.println("Inputs");
		System.out.println("numRows=" + numRows);
		System.out.println("numColumns=" + numColumns);
		System.out.println("lot=" + lot);
		int result = removeObstacle(numRows, numColumns, lot);
		System.out.println("result=" + result);
	}

	public static int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
		return 0;
	}
}