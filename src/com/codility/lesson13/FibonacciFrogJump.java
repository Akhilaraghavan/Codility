package com.codility.lesson13;

	import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FibonacciFrogJump {

	public static void main(String args[]) {
		FibonacciFrogJump fJump = new FibonacciFrogJump();
		int[] A = { 1, 1, 1, 1, 1};
		System.out.println(fJump.solution(A));
	}

	public int solution(int[] A) {
		int maxJumps = 0;
		int N = A.length;
		fibonacci(N+5);
		if (N == 0 ||  isFibonacci(N+1) ) {
			return 1;
		}
		
		int start = 0;
		int last = N-1;
		while (last >= start) {
			if (A[last] == 1 && isFibonacci((last - start) + 1)) {
				++maxJumps;
				start = last + 1;
				last = N;
			} 
			--last;
		}

	
		return maxJumps == 0 ? -1 : maxJumps + 1;
	}

	private boolean isFibonacci(int jumps) {
		return set.contains(jumps);
		//return series.stream().filter(num -> num == jumps).findFirst().isPresent();
	}

	List<Integer> series = new ArrayList<>();
	Set<Integer> set = new HashSet<>();

	private void fibonacci(int n) {
		set.add(0);
		series.add(0);
		series.add(1);
		set.add(0);
		for (int i = 2; i<=n; i++) {
			int fib = series.get(i-1) + series.get(i-2);
			series.add(fib);
			set.add(fib);
		}
	}

}
