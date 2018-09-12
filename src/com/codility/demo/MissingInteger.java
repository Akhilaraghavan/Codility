package com.codility.demo;

import java.util.Arrays;

public class MissingInteger {
	 public int solution(int[] A) {
		 A = Arrays.stream(A)
		 .filter(num -> num>0)
		 .distinct()
		 .sorted().toArray();
		
		 if (A.length == 1) {
			 if (A[0] == 1) {
				 return 2;
			 }
			return 1;
		 }

		 int smallestPositive = 1;
		 for (int i = 0; i<A.length; i++) {
			if (smallestPositive != A[i]) {
				break;
			}
			++smallestPositive;
		 }
		 return smallestPositive;
	 }

	 public static void main(String args[]) {
		 MissingInteger s = new MissingInteger();
		 int[] arr = {2};
		 System.out.println(s.solution(arr));
	 }
}
