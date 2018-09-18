package com.codility.cirrus;

public class MatrixSearch_Recursive {
	public int solution(int[][] A) {

		if (A.length <= 0) {
			return -1;
		}

		int rows = A.length;
		int columns = A[0].length;
		int numberOfCountries = 0;
		boolean[][] visited = new boolean[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (visited[i][j]) {
					continue;
				}
				++numberOfCountries;
			
				int color = A[i][j];
				int row = i;
				int column = j;
				checkColor(row, column, color, visited, A);
			}

		}

		return numberOfCountries;
	}
	
	public void checkColor(int row , int column, int color, boolean[][] visited, int[][] A) {
		if (row < 0 || row >= A.length) {
			return;
		}
		if (column < 0 || column >= A[0].length) {
			return;
		}
		if (visited[row][column]) {
			return;
		}
		if  (A[row][column] != color) {
			return;
		}
		visited[row][column] = true;
		checkColor(row - 1, column, color, visited, A);
		checkColor(row + 1, column, color, visited, A);
		checkColor(row, column -1, color, visited, A);
		checkColor(row, column + 1, color, visited, A);
	}

	public static void main(String args[]) {
		MatrixSearch_Recursive ms = new MatrixSearch_Recursive();
		int[][] matrix = new int[][] { { 5,4, 4 }, { 4, 3, 4 }, { 3, 2, 4 }, { 2, 2, 2 }, { 3, 3, 4 }, { 1, 4, 4 },
				{ 4,1,1 } };
		System.out.println(ms.solution(matrix));
	}
}
