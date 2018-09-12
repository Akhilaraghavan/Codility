package com.codility.lesson3;

public class SplitTape {
	public int solution(int[] A) {
		int leftSum = 0;
		int rightSum = 0;
		int minDifference = Integer.MAX_VALUE;
		
		if (A.length == 0) {
			return 0;
		}
		if (A.length == 1) {
			return A[0];
		}
		for (int i =0; i<A.length - 1;i++) {
			if (i == 0) {
				leftSum = A[i];
				for (int j = i+1; j<A.length;j++) {
					rightSum += A[j];
				}
			} else {
				leftSum += A[i];
				rightSum -= A[i];
			}
			minDifference = Math.min(minDifference, Math.abs(leftSum-rightSum));
		}
		return minDifference;
	}
	
	public static void main(String args[]) {
		SplitTape st = new SplitTape();
		int[] arr = {3, 1, 2, 4, 3};
		System.out.println(st.solution(arr));
	}
}
