package hackerrank;

public interface FirstInterface {
	String talk();
	default String whisper() {
		return talk() + ", but softer";
	}
	
	default String yell() {
		return talk() +" but louder";
	}
}
