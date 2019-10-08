package interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

//import interview2.Cell;

public class SolutionRobotClean {
	int removeObstacle(int numRows,int numColumns,List<List<Integer>> lot) {
		//Constraintspackage interview;
		Field field =new Field(numRows, numColumns, lot);
		return field.removeObstacle(); //(int) field.lstCells.stream().map(e->e.lstAdjacents.size() ).count() ;
	}
}

class Field{
	int numRows;
	int numColumns;
	List<List<Integer>> lot;
	List<Cell> lstCells;
	public Field(int numRows,int numColumns,List<List<Integer>> lot){
		this.numRows = numRows;
		this.numColumns =numColumns;
		this.lot =lot;
		int x=0,y=0;
		lstCells= new ArrayList<>();
		for(List<Integer> Rows :lot) {
			for (Integer cellInfo: Rows ) {
				Cell cell = new Cell(x, y,cellInfo );
				lstCells.add(cell);
				y++;
			}
			x++;
			y=0;
		}
// generar error por la clase inner cuidado.		lot.stream().limit(numRows).map(row->
//		{
//			row.stream().limit(numColumns).map(cell->
//			{
//				lstCells.add(new Cell(x, y, cell ));
//				return 0;
//			}).count();
//			return 0;
//		}).count();
		generarGrafo();
	}
	
	void generarGrafo() {
		//generate the graph following the rules
		lstCells.stream().map(current->{
			lstCells.stream().filter(e->current.x== e.x-1 && current.y== e.y && e.kindCell != KindCell.TRENCHES).map(e->{current.lstAdjacents.add(e);return 0;}).count();
			lstCells.stream().filter(e->current.x== e.x+1 && current.y== e.y && e.kindCell != KindCell.TRENCHES).map(e->{current.lstAdjacents.add(e);return 0;}).count();
			lstCells.stream().filter(e->current.x== e.x && current.y== e.y+1 && e.kindCell != KindCell.TRENCHES).map(e->{current.lstAdjacents.add(e);return 0;}).count();
			lstCells.stream().filter(e->current.x== e.x && current.y== e.y-1 && e.kindCell != KindCell.TRENCHES).map(e->{current.lstAdjacents.add(e);return 0;}).count();
			return 0;
		}).count();
	}
	int removeObstacle() {
		Cell cellStart =	lstCells.stream().filter(e->e.x==0 && e.y==0 ).collect(Collectors.toList()).get(0) ;
		Cell cellEnd =lstCells.stream().filter(e->e.kindCell == KindCell.OBSTACLE).collect(Collectors.toList()).get(0) ;
		if ( cellStart == null || cellEnd == null )
			return -1;
		cellStart.distance=0;
		cellStart.visited=true;
		do{
			int Vecdistance = cellStart.distance;
			cellStart.lstAdjacents.stream().map(e->{
				//e.calculateDistance();
				if(e.getDistance() >= Vecdistance )
					e.distance=Vecdistance+1;					
				return 0;
			}).count() ;
			cellStart.visited=true;
			cellStart = lstCells.stream().filter(e->!e.visited).sorted(Comparator.comparing(Cell::getDistance)).findFirst().orElse(null) ;
		}while(cellStart != null);
		return cellEnd.distance;
	}
}

class Cell{
	int x;
	int y;
	List<Cell> lstAdjacents;
	KindCell kindCell;
	boolean visited;
	int distance;
	int getDistance() {
		return this.distance;
	}
	Cell(int x,	int y,int value){
		this.x=x;
		this.y=y;
		this.lstAdjacents = new ArrayList<Cell>();
		if (value == 0) kindCell=kindCell.TRENCHES;
		if (value == 1) kindCell=kindCell.FLAT ;
		if (value == 9) kindCell=kindCell.OBSTACLE;
		
		visited=false;
		distance = Integer.MAX_VALUE;
	}
	void calculateDistance(Cell source){
		if(this.distance> source.distance)
			this.distance = source.distance+1;
	}
}

enum KindCell{ FLAT,TRENCHES,OBSTACLE}