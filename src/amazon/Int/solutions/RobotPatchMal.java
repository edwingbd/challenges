package amazon.Int.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class RobotPatchMal {
	public static void main(String[] args) {

		List<List<Integer>> lot = new ArrayList<>();
		lot.add(new ArrayList<>(Arrays.asList(1,0,0)));
		lot.add(new ArrayList<>(Arrays.asList(1,0,0)));
		lot.add(new ArrayList<>(Arrays.asList(1,9,1)));
		int numRows=3;
		int numColumns=3;
		System.out.println("Inputs");
		System.out.println("	numRows="+numRows);
		System.out.println("	numColumns="+numColumns);
		lot.stream().forEach(System.out::println);
		int result=removeObstacle(numRows, numColumns, lot) ;
		System.out.println("result="+result);
		
		//// test 2
		lot = new ArrayList<>();
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,9)));
		numRows=6;
		numColumns=6;
		System.out.println("Inputs");
		System.out.println("	numRows="+numRows);
		System.out.println("	numColumns="+numColumns);
		lot.stream().forEach(System.out::println);
		result=removeObstacle(numRows, numColumns, lot) ;
		System.out.println("result="+result);
		
		/////test 3
		lot = new ArrayList<>();
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		lot.add(new ArrayList<>(Arrays.asList(0,0,1,0,0,0)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,0)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,0)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,0)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,9)));
		numRows=6;
		numColumns=6;
		System.out.println("Inputs");
		System.out.println("	numRows="+numRows);
		System.out.println("	numColumns="+numColumns);
		lot.stream().forEach(System.out::println);
		result=removeObstacle(numRows, numColumns, lot) ;
		System.out.println("result="+result);

		/////test 4
		lot = new ArrayList<>();
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,1)));
		lot.add(new ArrayList<>(Arrays.asList(1,1,1,1,1,9)));
		numRows=6;
		numColumns=6;
		System.out.println("Inputs");
		System.out.println("	numRows="+numRows);
		System.out.println("	numColumns="+numColumns);
		lot.stream().forEach(System.out::println);
		result=removeObstacle(numRows, numColumns, lot) ;
		System.out.println("result="+result);
	
	}
	public static int removeObstacle(int numRows, int numColumns,List<List<Integer>> lot) {
		
		List<Field> lstFields = new ArrayList<Field>();
		int[][] arr = lot.stream()
			    .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
			    .toArray(int[][]::new);
		for(int i=0;i<numRows;i++) {
			for(int j=0;j<numColumns;j++) {
				if(arr[i][j] ==1 || arr[i][j] ==9  )
				{
					Field field = new Field(arr[i][j],i,j,i*numColumns+j) ;
					lstFields.add(field);
				}
			}
		}
		//lstFields.forEach(System.out::println);
		for(Field field : lstFields) {
			List<Field> neighborhoods=new ArrayList<Field>();
			int up=-1,right=-1,down=-1,left=-1;
			if((field.row-1) >=0)
				up = (field.row-1)*numColumns+field.column;
			if(field.column+1<numColumns)
				right = field.row*numColumns+(field.column+1);
			if(field.row+1<numRows)
				down = (field.row+1)*numColumns+field.column;
			if(field.column-1 >=0 )
				left = field.row*numColumns+(field.column-1);
			List<Integer> slst = Arrays.asList(new Integer[] {up,right,down,left});
			System.out.println("		up="+up+" right="+right+" down="+down+" left="+left);
			neighborhoods = lstFields.stream().filter(e-> slst.contains(e.id) ).collect(Collectors.toList());
			field.neighborhoods=neighborhoods;
		}
		
		int jumps=1;
		lstFields.get(0).visited =true;
		lstFields.get(0).jumps=jumps;
		Queue<Field> queue = new LinkedList<Field>();
		queue.add(lstFields.get(0));
		while(!queue.isEmpty()) {
			Field fieldReview = queue.poll();
			jumps=fieldReview.jumps+1;
			if(!fieldReview.visited) {
				fieldReview.visited = true;
				fieldReview.jumps=jumps;
				if(fieldReview.value==9)
					break;
			}
			else {
				if(fieldReview.jumps == -1 || jumps<fieldReview.jumps )
					fieldReview.jumps=jumps;
			}
			queue.addAll(fieldReview.neighborhoods.stream().filter(e->e.visited==false)
					.filter(e->!queue.contains(e)).collect(Collectors.toList()) );
		}
		//System.out.println(lstFields.stream().map(e->"id="+e.id+" value="+e.value+" quantityNeighbors="+e.neighborhoods.size()+" jumps=" + e.jumps +" ").reduce("\n\r", (a,b)->a+b ));
		return lstFields.stream().filter(e->e.value==9).map(e->e.jumps).findFirst().orElse(0) ;
	}
	
	static class Field{
		int id;
		int value=-1;
		int row;
		int column;
		List<Field> neighborhoods=new ArrayList<Field>();
		boolean visited=false;
		int jumps=0;
		
		public Field(int value, int row, int column,int id) {
			this.id=id;
			this.value=value;
			this.row=row;
			this.column=column;
		}
	}
}





































