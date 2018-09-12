package com.codility.cirrus;

public class MatrixSearch {
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

				int color = A[i][j];
				++numberOfCountries;
				visited[i][j] = true;
				boolean isDecrementCountryCount = false;
				
				if (i - 1 >= 0 && A[i - 1][j] == color) {
					
					if (!visited[i - 1][j]) {
						visited[i - 1][j] = true;
					} else if (!isDecrementCountryCount){
						isDecrementCountryCount = true;
						--numberOfCountries;
					}
				}
				if (i + 1 < rows && A[i + 1][j] == color) {
					if (!visited[i + 1][j]) {
						visited[i + 1][j] = true;
					} else if (!isDecrementCountryCount){
						isDecrementCountryCount = true;
						--numberOfCountries;
					}
				}
				if (j - 1 >= 0 && A[i][j - 1] == color) {
					if (!visited[i][j - 1]) {
						visited[i][j - 1] = true;
					} else if (!isDecrementCountryCount){
						isDecrementCountryCount = true;
						--numberOfCountries;
					}
				}
				if (j + 1 < columns && A[i][j + 1] == color) {
					if (!visited[i][j + 1]) {
						visited[i][j + 1] = true;
					} else if (!isDecrementCountryCount){
						isDecrementCountryCount = true;
						--numberOfCountries;
					}
				}

			}

		}

		return numberOfCountries;
	}

	public static void main(String args[]) {
		MatrixSearch ms = new MatrixSearch();
		int[][] matrix = new int[][] { { 5, 5, 5 }, { 5, 5, 5 }, { 5, 5, 5 }, { 5, 5, 5 }, { 5, 5, 5 }, { 5, 5, 5 },
				{ 5, 5, 5 } };
		System.out.println(ms.solution(matrix));
	}
}
