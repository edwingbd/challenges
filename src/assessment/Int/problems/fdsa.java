package assessment.Int.problems;

public class fdsa {
	// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
	// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
	// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static void floodFill(int row, int col, int[][] field, boolean[][] checked) {
		if (field[row][col] == 0 || checked[row][col])
			return;
		checked[row][col] = true;
		if (col < field[0].length - 1)
			floodFill(row, col + 1, field, checked);
		if (row < field.length - 1)
			floodFill(row + 1, col, field, checked);
		if (col > 0)
			floodFill(row, col - 1, field, checked);
		if (row > 0)
			floodFill(row - 1, col, field, checked);
	}

	int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid) {
		// WRITE YOUR CODE HERE
		int[][] matri = new int[rows][column];
		int i = 0;
		int j = 0;

		for (List<Integer> row : grid) {
			matri[i] = new int[column];
			for (Integer col : row) {
				matri[i][j] = col;
				j++;
			}
			i++;
			j = 0;
		}

		boolean[][] checked = new boolean[rows][column];

		for (i = 0; i < rows; i++) {
			for (j = 0; j < column; j++) {
				checked[i][j] = false;
			}
		}
		int numOfStores = 0;
		for (i = 0; i < matri.length; i++) {
			for (j = 0; j < matri[i].length; j++) {
				if (checked[i][j])
					continue;
				if (matri[i][j] == 0) {
					checked[i][j] = true;
					continue;
				}
				numOfStores++;
				floodFill(i, j, matri, checked);
			}
		}
		return numOfStores;
	}
	// METHOD SIGNATURE ENDS

}}
