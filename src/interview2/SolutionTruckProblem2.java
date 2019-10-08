package interview2;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionTruckProblem2{
	
	public static void main(String[] args) {
		List<List<Integer>> allLocations = new ArrayList<>();
		int numDestinations = 6;
		int numDeliveries =5;
		allLocations.add(new ArrayList<Integer>(Arrays.asList(1,2 ) ) );
		allLocations.add(new ArrayList<Integer>(Arrays.asList(3,4 ) ) );
		allLocations.add(new ArrayList<Integer>(Arrays.asList(2,1 ) ) );
		allLocations.add(new ArrayList<Integer>(Arrays.asList(1,-1) ) );
		allLocations.add(new ArrayList<Integer>(Arrays.asList(-1,-1) ) );
		allLocations.add(new ArrayList<Integer>(Arrays.asList(-1,1) ) );
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
			//throw new IllegalArgumentException("The value of the numDeliveries must be igual or less than the numDestinations");
		}
		
		Location btLocations = new Location(0,0); //the root is the location of the truck
		
		for (List<Integer> coordsLocations: allLocations ) {
			btLocations.add(new Location(coordsLocations.get(0),coordsLocations.get(1)));
		}
		//btLocations.printInOrder();
		btLocations.setVisited(true);
		//btLocations.printInOrder();
		return btLocations.visitedLocations().subList(0,numDeliveries ) ;  
	}
}
	class Location{
		private int locX;
		private int locY;
		private double distance;
		private boolean visited=false;
		Location right;
		Location left;
		
		public List<List<Integer>> visitedLocations(){
			// it have to visit all the locations in order, leaf, root right
			List<List<Integer>> lstReturn = new ArrayList<>();
			if (left != null)
				lstReturn.addAll(left.visitedLocations());
			if (!this.visited)
				lstReturn.add(this.visiteLocation());
			if (right != null)
				lstReturn.addAll(right.visitedLocations());
			return lstReturn;
		}
		
		public ArrayList<Integer> visiteLocation() {
			this.visited=true;
			return new ArrayList<Integer>(Arrays.asList(this.locX,this.locY));
		}
		
		public void add(Location newLocation) {
			if(newLocation.distance >= this.distance)
			{//right leaf if is greater or equal
				if(this.right==null)
					this.right=newLocation;
				else
					this.right.add(newLocation);
			}
			else {// left leaf because is less
				if(this.left==null)
					this.left=newLocation;
				else
					this.left.add(newLocation);
			}
				
		}
		
		public void printInOrder() {
			if (left!=null) {
				left.printInOrder();
			}
			System.out.println(","+this.distance +" ");
			if (right!=null) {
				right.printInOrder();
			}
				
		}
		
		public double getDistance() {
			return this.distance;
		}
		
		public int getLocX() {
			return this.locX;
		}
		
		public int getLocY() {
			return this.locY;
		}
		
		public void setVisited(boolean value) {
			this.visited = true;
		}
		
		public Location(int locX,int locY) {
			this.locX=locX;
			this.locY=locY;
			this.distance =  Math.sqrt(Math.pow(this.locX, 2)+Math.pow(this.locY, 2));
			this.visited = false;
		}	
	}