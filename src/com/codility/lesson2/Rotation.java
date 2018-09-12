package com.codility.lesson2;

import java.util.Arrays;

public class Rotation {

	public int[] solution(int[] A, int K) {
		int[] sol = new int[A.length];
		for (int i = 0; i<A.length ;i++) {
			int index = (i+K)%A.length;
			sol[index] = A[i];
		}
		return sol;
	}
	
	public static void main(String args[]) {
		Rotation rotation = new Rotation();
		int[] arr = {-1000, 2, 3, 1000};
		int noOfRotations = 99;
		Arrays.stream(rotation.solution(arr, noOfRotations)).forEach(System.out::println);
		
	}
	
	
}
