package interview;

import junit.framework.TestCase;

public class SumOfTwoTest  extends TestCase {
		public void testSumExistsTrue() {
			int[] arr = {1,3,5,9,15};
			int z = 18;
			assertTrue(SumOfTwo.sumExists1(arr, z));
		}
	    public void testSumExistsFalse() {
	    	int[] arr = {1,3,5,9,15};
			int z = 2;
			assertFalse(SumOfTwo.sumExists1(arr, z));
		}
	    public void testSumExistsRepeats() {
	    	int[] arr = {3,3};
	    	int z = 6;
	    	assertFalse(SumOfTwo.sumExists1(arr, z));
	    }
	    
		public void testSumExistsTrue2() {
			int[] arr = {1,3,5,9,15};
			int z = 18;
			assertTrue(SumOfTwo.sumExists2(arr, z));
		}
	    public void testSumExistsFalse2() {
	    	int[] arr = {1,3,5,9,15};
			int z = 2;
			assertFalse(SumOfTwo.sumExists2(arr, z));
		}
	    public void testSumExistsRepeats2() {
	    	int[] arr = {3,3};
	    	int z = 6;
	    	assertFalse(SumOfTwo.sumExists2(arr, z));
	    }
	    
}
