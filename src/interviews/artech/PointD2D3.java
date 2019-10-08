package interviews.artech;

public class PointD2D3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point3D point = new Point3D((byte) 1,(byte) 2,(byte) 3 );
		Point2D point2D = new Point2D((byte) 1,(byte) 2 );
		Point3D point2 = new Point3D((byte) 4,(byte) 5,(byte) 6 );
		point2D.printDistance(point.dist2D(point2) );
		point.printDistance(point.dist3D(point2) );
	}

}

class Point2D{
	private byte x;
	private byte y;
	public byte getX() {
		return this.x;
	}
	public byte getY() {
		return this.y;
	}
	public Point2D(byte x,byte y) {
		this.x=x;
		this.y=y;
	}
	
	public double dist2D(Point2D p) {
		double rtrnDist = Math.sqrt( Math.pow((p.getX()- this.getX()), 2) + Math.pow( (p.getY()- this.getX() ) , 2));  
		//return (int) rtrnDist;
		return Math.ceil(rtrnDist) ;
	}
	public void printDistance(double d) {
		System.out.println("2D distance = "+ d );
	}
}

class Point3D extends Point2D{
	private byte z;
	public byte getZ() {return this.z;}
	public Point3D(byte x,byte y,byte z) {
		super(x, y);
		this.z=z;
	}
	
	public double dist3D(Point3D p) {
		double rtrnDist = Math.sqrt( Math.pow((p.getX()- this.getX()), 2) + Math.pow( (p.getY()- this.getY()) , 2) + Math.pow( (p.getZ() - this.getZ()) , 2) );  
		return Math.ceil(rtrnDist) ;
	}
	
	public void printDistance(double d) {
		System.out.println("3D distance = "+ d );
	}
}
