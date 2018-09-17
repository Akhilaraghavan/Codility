package com.codility.cirrus;

public class CodilityCodersTest {
	
	private static final String CODILITY = "Codility";
	private static final String TEST = "Test";
	private static final String CODERS = "Coders";

	public void solution(int N) {
		
		if (N < 1 || N > 1000) {
			return;
		}
		
		for (int i = 1; i<=N; i++) {
			if (i % 30 == 0) {
				System.out.println(CODILITY + TEST + CODERS);
			} else if (i % 15 == 0) {
				System.out.println(TEST + CODERS);
			} else if (i % 10 == 0) {
				System.out.println(CODILITY + CODERS);
			} else if (i % 6 == 0) {
				System.out.println(CODILITY + TEST);
			} else if (i% 5 == 0) {
				System.out.println(CODERS);
			} else if (i % 3 == 0) {
				System.out.println(TEST);
			} else if (i % 2 == 0) {
				System.out.println(CODILITY);
			} else {
				System.out.println(i);
			}
		}
	}
	
	
	public static void main(String args[]) {
		CodilityCodersTest codersTest = new CodilityCodersTest();
		codersTest.solution(1000);
	}
}
