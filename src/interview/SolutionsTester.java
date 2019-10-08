package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import interview2.SolutionTruckProblem2;

public class SolutionsTester {

	public static void main(String[] args) {
				
		System.out.println("--------------------Truck-----------------");
		// Test Truck problem
		SolutionTruckProblem sTruckProblem = new SolutionTruckProblem();
		SolutionTruckProblem2 sTruckProblem2 = new SolutionTruckProblem2();
		List<List<Integer>> allLocations = new ArrayList<>();
		int numDestinations = 3;
		int numDeliveries =2;
		allLocations.add(new ArrayList<Integer>(Arrays.asList(1,2 ) ) );
		allLocations.add(new ArrayList<Integer>(Arrays.asList(3,4 ) ) );
		//allLocations.add(new ArrayList<Integer>(Arrays.asList(2,1 ) ) );
		allLocations.add(new ArrayList<Integer>(Arrays.asList(1,-1) ) );
		//allLocations.add(new ArrayList<Integer>(Arrays.asList(-1,-1) ) );
		//allLocations.add(new ArrayList<Integer>(Arrays.asList(-1,1) ) );
		System.out.println("Inputs:");
		System.out.println("numDestinations:"+numDestinations);
		System.out.println("numDeliveries:"+numDeliveries);
		System.out.println("allLocations:"+allLocations);
		System.out.println("output solution1:"+sTruckProblem.ClosestXdestinations(numDestinations, allLocations, numDeliveries));
		System.out.println("output solution2:"+sTruckProblem2.ClosestXdestinations(numDestinations, allLocations, numDeliveries));

			
		System.out.println("--------------------Aircraft-----------------");
		SolutionAircraft sAircraft = new SolutionAircraft();
		List<List<Integer>> forwardRouteList = new ArrayList<>() ;
		List<List<Integer>> returnRouteList = new ArrayList<>() ;
		int maxTravelDist;
		/// example 1
		maxTravelDist = 7000;
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(1,2000)) );
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(2,4000)) );
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(3,6000)) );
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(1,2000)) );
		System.out.println("Inputs:");
		System.out.println("maxTravelDist:"+maxTravelDist);
		System.out.println("forwardRouteList:"+forwardRouteList);
		System.out.println("returnRouteList:"+returnRouteList);
		System.out.println("output:"+sAircraft.optimalUtilization(maxTravelDist,forwardRouteList,returnRouteList));
		forwardRouteList.clear();
		returnRouteList.clear();
		
		maxTravelDist = 10000;
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(1,3000)) );
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(2,5000)) );
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(3,7000)) );
		forwardRouteList.add(new ArrayList<Integer>(Arrays.asList(4,10000)) );
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(1,2000)) );
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(2,3000)) );
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(3,4000)) );
		returnRouteList.add(new ArrayList<Integer>(Arrays.asList(4,5000)) );
		System.out.println("Inputs:");
		System.out.println("maxTravelDist:"+maxTravelDist);
		System.out.println("forwardRouteList:"+forwardRouteList);
		System.out.println("returnRouteList:"+returnRouteList);
		System.out.println("output:"+sAircraft.optimalUtilization(maxTravelDist,forwardRouteList,returnRouteList));
		
		
	}

}
