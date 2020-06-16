package amazon.Int.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

/*Amazon fresh is a grocery delivery service that 0Ffers consumers the option 0F purchasing their groceries online and schedule future deliveries 0F purchses grocerries amazon's backend system dinamimcally tracks each amazon fresh delivery truck and automatically assigns the next deliveries in a truck's plan to accomplish this. The system generates an optimized delivery plan with x destinations. The most optimized plan would deliver to the closest x destination from the star amoung all 0F the possible destinations in the plan.
given an array 0F n possibles deliver destination, implment an algorithm to create the delivery plan for the closest X destinations
Input: 
the input to the function/methos consist 0F theree arguments:
numdestination and integer representin the total number 0F possible delivery destinations for the truck (N);
all location a, list wher each element consist 0F a pair 0F integers representin the x and y coordinates 0F the delivery locations
numDeliveries and integer represeint the number 0F deliveries that will be deliveries in the plan(x)
Output
Return a list 0F elements where each element 0F the list represent the x and y integer coordinates 0F the delivery destinations.
constraints
numDeliveries <= numdestinations
Note
the plan starts from the truck's location [0,0]. The distance 0F the truck form a delivery destination (x,y) is the square root 0F x2+y2 if there are ties then return any 0F the locations as long as you satisfy returning X deliveries.

Example
Input: numDestination =3
allLocations[[1,2],[3,4],[1,-1]]
numDeliveries =2
Output : [[1,-1],[1,2]]
Explanation:
The distance 0F the truck form location [1,2],is square root (5) = 2.236
The distance 0F the truck form location [3,4],is square root (9+16=25) = 5
The distance 0F the truck form location [1,-1],is square root (1+1=2) = 1.4
numDeliveris is 2 hence the output is [1,-1] and [1,2]


 * */
// TJHIS IS NOT EFFICEIN IS GOOD BECAUSE USE THE TREEMAP BUT IS NO THE BEST OPTION.
// BECAUSE IS SAVING THE INFORMATION
public class Trucks {
	public static void main(String[] args) {
		List<List<Integer>> allLocations = new ArrayList<>();
		int numDestinations = 6;
		int numDeliveries = 5;
		allLocations.add(new ArrayList<Integer>(Arrays.asList(10, 2)));
		allLocations.add(new ArrayList<Integer>(Arrays.asList(3, 40)));
		allLocations.add(new ArrayList<Integer>(Arrays.asList(10, 2)));
		allLocations.add(new ArrayList<Integer>(Arrays.asList(3, 40)));
		allLocations.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
		allLocations.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
		allLocations.add(new ArrayList<Integer>(Arrays.asList(2, 1)));
		allLocations.add(new ArrayList<Integer>(Arrays.asList(1, -1)));
		allLocations.add(new ArrayList<Integer>(Arrays.asList(-1, -1)));
		allLocations.add(new ArrayList<Integer>(Arrays.asList(-1, 1)));
		System.out.println("Inputs:");
		System.out.println("numDestinations:" + numDestinations);
		System.out.println("numDeliveries:" + numDeliveries);
		System.out.println("allLocations:" + allLocations);
		System.out.println("output:" + ClosestXdestinations(numDestinations, allLocations, numDeliveries));
	}

	// method signature beigns, this method is requiered
	public static List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations,
			int numDeliveries) {
		List<List<Integer>> lstReturn = new ArrayList<List<Integer>>();

		TreeMap<Integer, List<List<Integer>>> tmDestination = new TreeMap<Integer, List<List<Integer>>>();

		for (List<Integer> location : allLocations) {
			Integer key = (int) (Math.pow(location.get(0), 2) + Math.pow(location.get(1), 2));
			List<List<Integer>> value = null;

			if (tmDestination.containsKey(key))
				value = tmDestination.get(key);
			else
				value = new ArrayList<List<Integer>>();

			value.add(location);
			tmDestination.put(key, value);

		}
		while(lstReturn.size() < numDeliveries ) {
			Entry<Integer, List<List<Integer>>> entry=tmDestination.pollFirstEntry();
			List<List<Integer>> value = entry.getValue(); //tmDestination.firstEntry().getValue() ;
			lstReturn.add(value.remove(0));
			if(value.size() >=1 )
				tmDestination.put(entry.getKey(), value);
		}
		
		return lstReturn;
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
 * */