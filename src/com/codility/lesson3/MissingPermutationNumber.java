package com.codility.lesson3;

import java.util.Arrays;

public class MissingPermutationNumber {

	public int solution(int[] A) {
		Arrays.sort(A);
		int i = 0;
		int next = 0;
		
		if (A.length == 0) {
			return 1;
		}
		
		if (A.length == 1 && A[0] != 1) {
			return 1;
		}
		
		while(i < A.length) {
			if (i != 0 && next + 1 != A[i]){
				return next+1;
			} 
			next = A[i];
			++i;
		}
		return 1;
		/*
		int[] arr = new int[A.length] ;
		for (int i =0; i<A.length;i++) {
			if (A[i] > A.length) {
				continue;
			}
			arr[A[i]-1] = A[i];
		}
		int i = 0;
		while (i<A.length) {
			if (arr[i] ==0) {
				break;
			}
			++i;
		}
		return i+1;*/
	}
	
	
	public static void main(String args[]) {
		MissingPermutationNumber mn = new MissingPermutationNumber();
		int arr[] = {3,1};
		System.out.println(mn.solution(arr));
	}
}
