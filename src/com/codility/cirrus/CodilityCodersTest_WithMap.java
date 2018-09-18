package com.codility.cirrus;

import java.util.LinkedHashMap;
import java.util.Map;

public class CodilityCodersTest_WithMap {

	private static final String CODILITY = "Codility";
	private static final String TEST = "Test";
	private static final String CODERS = "Coders";

	private static Map<Integer, String> map = new LinkedHashMap<>();
	static {
		map.put(30, CODILITY + TEST + CODERS);
		map.put(15, TEST + CODERS);
		map.put(10, CODILITY + CODERS);
		map.put(6, CODILITY + TEST);
		map.put(5, CODERS);
		map.put(3, TEST);
		map.put(2, CODILITY);
	}

	public void solution(int N) {

		if (N < 1 || N > 1000) {
			return;
		}
		for (int i = 1; i <= N; i++) {
			final int num = i;
			print(map.keySet().stream().filter(key -> num % key == 0)
					.map(key -> map.get(key))
					.findFirst()
					.orElse(i + ""));
		}

	}

	private void print(String num) {
		System.out.println(num);
	}

	public static void main(String args[]) {
		CodilityCodersTest_WithMap codersTest = new CodilityCodersTest_WithMap();
		codersTest.solution(1000);
	}
}
