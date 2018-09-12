package com.codility.lesson1;

public class BinaryGap {

	
	public static void main(String args[]) {
	
		BinaryGap gap = new BinaryGap();
		int n =2147483647;
		System.out.println(gap.solution(n));
	}
	
	public int solution(int N) {
		int maxGap = 0;
		String s = convertTobinary(N);
		boolean counting = false;
		int gap = 0;
		for (int i =0; i<s.length(); i++) {
			if (s.charAt(i) == '1') {
				if (counting) {
					maxGap = Math.max(gap, maxGap);
				}
				gap = 0;
				counting = true;
				continue;
			}
			
			if (counting && s.charAt(i) == '0') {
				++gap;
			}
		}
		return maxGap;
	}
	
	
	public String convertTobinary(int N) {
		String binary = "";
		if (N==1) {
			return "1";
		}
		while (N > 0) {
			binary += "" + N%2;
			N = N/2;
		}
		return binary;
	}
	
}
