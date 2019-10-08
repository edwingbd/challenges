package interview2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class SolutionRobotClean1 {
	int removeObstacle(int numRows,int numColumns,List<List<Integer>> lot) {
		//Constraints
		Field field = new Field(numRows, numColumns, lot);
		return (int) field.minimumDistance();
	}
}

// mejor
class Field{
	List<Cell> lstCells;
	int numX;
	int numY;
	List<List<Integer>> lot;
	Field(int numX, int numY,List<List<Integer>> lot ){
		this.numX=numX;
		this.numY=numY;
		this.lot=lot;
		lstCells=new ArrayList<>();
		generateCells();
		generateAdjacents();
	}
	
	int minimumDistance() {
		Cell cllStart = lstCells.stream().filter(e->e.x==0 && e.y == 0 ).findFirst().orElse(null) ;
		Cell cllEnd = lstCells.stream().filter(e->e.kind==KindCell.obstacle ).findFirst().orElse(null) ;
		if (cllStart==null || cllEnd==null) {
			return -1;
		}
		cllStart.distance=0;
		while (lstCells.stream().filter(e->!e.visited).count() >0 ) {
			lstCells.stream().filter(e->!e.visited).sorted(Comparator.comparingInt(Cell::getDistance)).findFirst().map(e->{
				e.calculateDistance();
			return 0;});
		}
		return cllEnd.getDistance() ;
	}
	
	void generateCells() {
		int x=0,y=0;
		for(List<Integer> row:lot.stream().limit(numX).collect(Collectors.toList()) ) {
			for(Integer cell:row.stream().limit(numY).collect(Collectors.toList()) ) {
				lstCells.add(new Cell(x,y,cell));
				y++;
			}	
			x++;
			y=0;
		}
	}
	void generateAdjacents() {
		lstCells.stream().map(e->{
			System.out.println("loc="+e.x+"-"+e.y);
			lstCells.stream().filter(e2-> (e.x == e2.x-1 ) && (e.y==e2.y)).map(e2->{e.lstAdjacents.add(e2); return 1;} ).count();
			lstCells.stream().filter(e2-> (e.x == e2.x+1 ) && (e.y==e2.y)).map(e2->{e.lstAdjacents.add(e2); return 1;} ).count();
			lstCells.stream().filter(e2-> (e.x == e2.x ) && (e.y==e2.y+1)).map(e2->{e.lstAdjacents.add(e2); return 1;} ).count();
			lstCells.stream().filter(e2-> (e.x == e2.x ) && (e.y==e2.y-1)).map(e2->{e.lstAdjacents.add(e2); return 1;} ).count();
			return 0;
		}).count();
	}
}

class Cell{
	int x;
	int y;
	List<Integer> value;
	KindCell kind;
	boolean visited;
	int distance;
	int getDistance() {
		return this.distance;
	}
	List<Cell> lstAdjacents;
	Cell(int x, int y,int kind){
		this.x=x;
		this.y=y;
		if(kind==0)	this.kind=KindCell.Flat;
		if(kind==1)	this.kind=KindCell.Trenches;
		if(kind==9)	this.kind=KindCell.obstacle;
		lstAdjacents = new ArrayList<>();
		this.distance = Integer.MAX_VALUE;
	}
	void calculateDistance(){
		//calculate the distance between the elemetns and the adjacents
		lstAdjacents.stream().sorted(Comparator.comparingInt(Cell::getDistance)).map(e->
		{
			if(e.distance>this.distance)
				e.distance=this.distance+1;
			return 0;
		}).count();
		this.visited=true;
	}
}

enum KindCell{Flat,Trenches,obstacle}