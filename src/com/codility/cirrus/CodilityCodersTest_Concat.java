package com.codility.cirrus;

import java.util.StringJoiner;

public class CodilityCodersTest_Concat {

	private static final String CODILITY = "Codility";
	private static final String TEST = "Test";
	private static final String CODERS = "Coders";

	public void solution(int N) {

		if (N < 1 || N > 1000) {
			return;
		}
		StringJoiner s = new StringJoiner("");
		for (int i = 1; i <= N; i++) {
			s= new StringJoiner("");
			s.setEmptyValue(i +"");
			if (i%2 == 0) {
				s.add(CODILITY);
			} 
			if (i%3 == 0) {
				s.add(TEST);
			}
			if (i%5 == 0) {
				s.add(CODERS);
			}
			System.out.println(s.toString());
		}

	}

	public static void main(String args[]) {
		CodilityCodersTest_Concat codersTest = new CodilityCodersTest_Concat();
		codersTest.solution(1000);
	}
}
