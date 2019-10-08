package interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class SolutionRobotClean0 {
	int removeObstacle(int numRows,int numColumns,List<List<Integer>> lot) {
		Field field = new Field(lot);
		return field.removeObstacle();
	}
}

class Field {
	private List<Cell> cellsField;
	private int maxX;
	private int maxY;
	private List<List<Integer>> lot;
	public Field(List<List<Integer>> lot) {
		this.lot=lot;
		this.maxX=lot.size();
		this.maxY=lot.get(0).size();
		cellsField = new ArrayList<Cell>();
		generateCellsField();
	}
	private void generateCellsField() {
		int x=0,y=0;
		for(List<Integer> Rows :lot) {
			for (Integer cellInfo: Rows ) {
				Cell cell = new Cell(x, y,(x*maxX+y) );
				cell.setkindCell(cellInfo);
				cellsField.add(cell);
				y++;
			}
			x++;
			y=0;
		}
		cellsField.stream().map(e->{
			addAdjacents(e);
			return 1;
		}).count();
	}
	public void addAdjacents(Cell cell) {
		Long changes=(long) 0;
		try {
			{//up
				changes += cellsField.stream()
						.filter(e->e.getKind()!=KindCell.Trenches)
						.filter(e->(e.getXPos() == cell.getXPos()+1 ) && (e.getYPos()==cell.getYPos() ))
						.map(e->{
							cell.getAdjacents().add(e);
							return 1;
						}).count();
			}
			{//down
				changes +=cellsField.stream()
						.filter(e->e.getKind()!=KindCell.Trenches)
				.filter(e->e.getXPos() == cell.getXPos()-1 && e.getYPos()==cell.getYPos() )
				.map(e->{
					cell.getAdjacents().add(e);
					return 1;
				}).count();
			}
			{//left
				changes +=cellsField.stream()
						.filter(e->e.getKind()!=KindCell.Trenches)
						.filter(e->e.getXPos() ==cell.getXPos() && e.getYPos()-1==cell.getYPos() )
						.map(e->{
							cell.getAdjacents().add(e);
							return 1;
						}).count();
			}
			{//right
				changes += cellsField.stream()
						.filter(e->e.getKind()!=KindCell.Trenches)
						.filter(e->e.getXPos() ==cell.getXPos() && e.getYPos()+1==cell.getYPos())
						.map(e->{
							cell.getAdjacents().add(e);
							return 1;
						}).count();
			}
		}
		catch(Exception e) {
			String str = e.getMessage();

		}
	}
	
	public int removeObstacle() {
		HashMap<Integer, Integer> hsLength ; //this is the
		if(cellsField.size()<2)
			return 0;
		else {
			Cell cellStart = cellsField.stream().filter(e->e.getXPos()==0 && e.getYPos() == 0).findAny().orElse(null);
			Cell cellEnd = cellsField.stream().filter(e->e.getKind() == KindCell.Obstacle).findAny().orElse(null);
			if (cellStart == null || cellEnd == null )
				return 0;
			Cell cellSource = cellStart;
			
			cellsField.stream().map(e->{
				e.setValueSteps(Integer.MAX_VALUE);
				return 1;
			}).count();
			cellSource.setValueSteps(0);
			
			do{
				for(Cell cellCheck: cellSource.getAdjacents()) {
					if (cellCheck != null && cellCheck.getValueSteps() > cellSource.getValueSteps()) {
						cellCheck.setValueSteps((cellSource.getValueSteps()+1));
					}
				}
				cellSource.setVisited(true);
				cellSource = cellsField.stream()
						.filter(e->!e.getVisited())
						.sorted(Comparator.comparingInt(Cell :: getValueSteps)).findFirst().orElse(null);
						
						//.collect(Collectors.toList()).get(0) ;
			}while(cellSource !=null ); 
			
			
			return cellEnd.getValueSteps();
		}
		
	}
}

enum KindCell { Flat,Trenches,Obstacle,Start}

class Cell  { //implements Comparable<Cell>
	private int valueSteps;
	public int getValueSteps() {
		return this.valueSteps;
	}
	public void setValueSteps(int valueSteps) {
		this.valueSteps = valueSteps;
	}

	private int key;
	private int xPos;
	private int yPos;
	private List<Cell> adjacents;
	private boolean visited;
	public void setVisited(boolean newValue) {
		this.visited = newValue;
	}
	private KindCell kind;
	public KindCell getKind() {
		return kind;
	}
	public int getKey() {
		return this.key;
	}
	public void setkindCell(int cellInfo) {
		switch (cellInfo) {
		case 0:
			this.kind=KindCell.Trenches;
			break;
		case 1:
			this.kind=KindCell.Flat ;
			break;
		case 9:
			this.kind=KindCell.Obstacle;
			break;
		default:
			break;
		}
	} 
	public List<Cell> getAdjacents() {
		return adjacents;
	}
	public void addAdjacents() {
				
	}
	public int getYPos(){
		return this.yPos;
	}
	public int getXPos(){
		return this.xPos;
	}
	public boolean getVisited(){
		return this.visited;
	}
	public Cell(int xPos,int yPos,int key) {
		this.xPos=xPos;
		this.yPos=yPos;
		this.key=key;
		this.adjacents= new ArrayList<Cell>();
		this.visited=false;
	}
}
