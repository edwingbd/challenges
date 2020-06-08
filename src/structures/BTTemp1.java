package structures;

//@Data
//this in general the structure of a binary just with the right and the left 
public class BTTemp1 {
	public Integer value;
	public BTTemp1 right;
	public BTTemp1 left;
	
	public BTTemp1(Integer value) {
		this.value =value;
	}
	
	public BTTemp1 addRight(Integer value) {
		this.right = new BTTemp1(value);
		return this.right;
	}
	
	public BTTemp1 addLet(Integer value) {
		this.left  = new BTTemp1(value);
		return this.left;
	}
}
