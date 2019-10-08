package hackerrank;

public interface SecondInterface {
	String talk();
	
	default String whisper() {
		return talk() + ", but less annoying";
	}
	
	default String shout() {
		return talk() +" but more annoying";
	}
}
