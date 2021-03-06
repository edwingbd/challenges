package assessment.Int.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*Amazon Prime Air is developeing a system that divides shipping route using flight optimization routing sustems to a cluster of aircraft that can fulfill these routes. Each shipping route is identifies by a unique integer identifier, requires a fixed non-zero amount of trave distance between airports, and is defined to be either a forward shipping route or a return shipping route, identifiers are guaranteed to be unique within their own route type, but not across route types.

Each aircraft should be assigned two shipping routes at once: one forward route and one return route. Due to the complex scheduling of flight plans, all airchraft have a fixed maximum operating travel distance, and cannot be sheduled to fly a shipping route that requires more travel distance than the preschibed maximum operating travel distance. the goal of the system is to optimize the total operating travel distance of a given aircraft. A forward/return shipping route pair is considered to be "optimal" if there does not exist another pair that has a higher operating travel distance that this pair, an also has a total less than or equal to the maximum operation travel distance of the aircraft

For example. If the aircraft has a maximum operating travel distance of 3000 miles, a forward/return shipping route pair using a total of 2900 miles would be optimal if there does not exit a pair that uses a total operating travel distance of 3000 miles. but would not be considered optimal if such a pair did exist.

Your Task is to Write an algorithm to optimize the sets of forward/return shipping route pairs that allow the air chraft to be optimally utilized. Given a list of forward shipping routes and a list of return shipping routes

Input
the input to the function/method consist of three arguments.
maxTravelDist, an integer representing the maximum operating travel distance of the given aircraft
forwardRouteList a list of pairs of integers where the first integer represents the unique identifier of a forward shipping route and the second integer represents the amount of travel distance requires by the shipping route

Output
Examples 1:
Input : maxTravelDist=7000
forwardRouteList=[[1,2000],[2,4000],[3,6000]]
returnRouteList=[[1,2000]]

Output [[2,1]]

Explanation:
There are only three combinations, [1,1],[2,1], and [3,1], which have a total of 4000, 6000, and 8000 miles, 
respectively, respectively. Since 6000 is the largest use that does not exceed 7000, [2,1]  is the optimal pair

Example 2:
input: maxTravelDist =10000
forwardRouteList=[[1,3000],[2,5000],[3,7000],[4,10000]]
returnRouteList=[[1,20000],[2,3000],[3,4000],[4,5000]]

Output: [[2,4],[3,2]]
Explanation:
There are two pairs of forward and return shipping routes possible that optimally utilizes the given aircraft.
Shipping Route ID#2 from the forwardShippingRouteList requires 5000 miles travelled and shipping route ID#4 form returnShippingRouteList also requires 5000 miles travelled. Combined, they add up to 10000 miles travelled. 
Similarly, Shipping Route ID#3 form forwardShippingRouteList requires 7000 miles travelled, and shipping Rourte ID#2 from returnShippingRouteList requires 3000 miles travelled. These also add up to 10000 miles travelled.
Therefore, the pairs of forward and return shipping routes that optimally utilize the aircraft are [2,4],[3,2].
*/

public class Air {
	public static List<List<Integer>> optimalUtilization(int maxTravelDist, List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRouteList) {
		List<List<Integer>> lstResult = new ArrayList<List<Integer>>();
		return lstResult;
	}


	public static void main(String[] arr) {
		System.out.println("--------------------Aircraft-----------------");
		// SolutionAircraft sAircraft = new SolutionAircraft();
		List<List<Integer>> forwardRouteList = new ArrayList<>();
		List<List<Integer>> returnRouteList = new ArrayList<>();
		int maxTravelDist;
		maxTravelDist = 10000;
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(1, 3000)));
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(2, 5000)));
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(3, 7000)));
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(4, 10000)));
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(1, 2000)));
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(2, 3000)));
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(3, 4000)));
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(4, 5000)));
		System.out.println("Inputs:");
		System.out.println("maxTravelDist:" + maxTravelDist);
		System.out.println("forwardRouteList:" + forwardRouteList);
		System.out.println("returnRouteList:" + returnRouteList);
		System.out.println("output:" + optimalUtilization(maxTravelDist, forwardRouteList, returnRouteList));
		forwardRouteList.clear();
		returnRouteList.clear();

		/// example 1
		maxTravelDist = 7000;
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(3, 6000)));
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(2, 4000)));
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(1, 2000)));
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(4, 8000)));
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(5, 2000)));
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(3, 6000)));
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(2, 4000)));
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(1, 2000)));
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(4, 12000)));
		System.out.println("Inputs:");
		System.out.println("maxTravelDist:" + maxTravelDist);
		System.out.println("forwardRouteList:" + forwardRouteList);
		System.out.println("returnRouteList:" + returnRouteList);
		System.out.println("output:" + optimalUtilization(maxTravelDist, forwardRouteList, returnRouteList));
		forwardRouteList.clear();
		returnRouteList.clear();

	}
}
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */