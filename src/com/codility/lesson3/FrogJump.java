package com.codility.lesson3;

public class FrogJump {
	public int solution(int X, int Y, int D) {
		int jumps = (Y - X) / D;
		return jumps += (Y - X) % D > 0 ? 1 : 0;
	}

	public static void main(String args[]) {
		FrogJump frogJump = new FrogJump();
		System.out.println(frogJump.solution(1, 10, 3));
	}
}
