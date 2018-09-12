package com.codility.lesson2;

import java.util.Arrays;

public class OddOccurences {
	public int solution(int[] A) {
		Arrays.sort(A);
		int i =0;
		while (i+1<A.length) {
			if (A[i] != A[i+1]) {
				break;
			}
			i+=2;
		}
		return A[i];
	}

	public static void main(String args[]) {
		OddOccurences oddOccurences = new OddOccurences();
		int[] arr = {100000000, 1, 100000000};
		System.out.println(oddOccurences.solution(arr));
	}
}
