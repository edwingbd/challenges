package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testSort {

	@Test
    public void positiveTest() {
        int[] actual = { 5, 1};
        int[] expected = { 1, 5 };
        structures.MergeSort mergesort = new MergeSort();
        mergesort.sort(actual);
        assertArrayEquals(expected, actual);
       // assertEquals(expected, actual);
       // Assert.assertArrayEquals(expected, actual);
    }
}
