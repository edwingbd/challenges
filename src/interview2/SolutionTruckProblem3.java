package interview;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionTruckProblem3{
	
	public static void main(String[] args) {
		List<List<Integer>> allLocations = new ArrayList<>();
		int numDestinations = 3;
		int numDeliveries =2;
		allLocations.add(new ArrayList<Integer>(Arrays.asList(1,2 ) ) );
		allLocations.add(new ArrayList<Integer>(Arrays.asList(3,4 ) ) );
		allLocations.add(new ArrayList<Integer>(Arrays.asList(1,-1) ) );
		System.out.println("Inputs:");
		System.out.println("numDestinations:"+numDestinations);
		System.out.println("numDeliveries:"+numDeliveries);
		System.out.println("allLocations:"+allLocations);
		System.out.println("output:"+ClosestXdestinations(numDestinations,allLocations,numDeliveries));
	}
	
	//method signature beigns, this method is requiered
	public static List<List<Integer>> ClosestXdestinations (
			int numDestinations,List<List<Integer>> allLocations,int numDeliveries)
	{
		List<List<Integer>> lstReturn = new ArrayList<>();
		if ( numDeliveries > numDestinations) {
			return lstReturn;// return the empty list
		}
		
		List<Location> lstLocations = new ArrayList<Location>();
		for (List<Integer> coordsLocations: allLocations ) {
			lstLocations.add(new Location(coordsLocations.get(0),coordsLocations.get(1)));
		}

		lstLocations=lstLocations
				.stream()
				.sorted(Comparator.comparingDouble(Location::getDistance))
				.collect(Collectors.toList()); 
		int countVisit=0;
		for (Location locVisit:lstLocations) {
			lstReturn.add(new ArrayList<Integer>( Arrays.asList(locVisit.getLocX(),locVisit.getLocY() ) ));
			countVisit++;
			if (countVisit >=numDeliveries)
					break;
		}
		
		return lstReturn;  
	}
}
	class Location{
		private int locX;
		private int locY;
		private double distance;
		
		public double getDistance() {
			return this.distance;
		}
		
		public int getLocX() {
			return this.locX;
		}
		
		public int getLocY() {
			return this.locY;
		}
		
		public Location(int locX,int locY) {
			this.locX=locX;
			this.locY=locY;
			this.distance =  Math.sqrt(Math.pow(this.locX, 2)+Math.pow(this.locY, 2));
		}	
	}