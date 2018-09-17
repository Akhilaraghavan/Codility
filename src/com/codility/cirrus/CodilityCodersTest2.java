package com.codility.cirrus;

import java.util.LinkedHashMap;
import java.util.Map;

public class CodilityCodersTest2 {
	
	private static final String CODILITY = "Codility";
	private static final String TEST = "Test";
	private static final String CODERS = "Coders";

	public void solution(int N) {
		
		if (N < 1 || N > 1000) {
			return;
		}
		Map<Integer, String> map =new LinkedHashMap<>();
		map.put(30, CODILITY + TEST + CODERS);
		map.put(15, TEST + CODERS);
		map.put(10, CODILITY+CODERS);
		map.put(6, CODILITY+TEST);
		map.put(5, CODERS);
		map.put(3, TEST);
		map.put(2, CODILITY);
		
		for (int i = 1; i<=N; i++) {
			final int num=i;
			print(map.keySet().stream()
					.filter(key -> num%key ==0)
					.map(key -> map.get(key))
					.findFirst().orElse(i + ""));
		}
		
	}
	
	private void print(String num) {
		System.out.println(num);
	}

	public static void main(String args[]) {
		CodilityCodersTest2 codersTest = new CodilityCodersTest2();
		codersTest.solution(1000);
	}
}
