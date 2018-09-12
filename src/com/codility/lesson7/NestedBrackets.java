package com.codility.lesson7;

import java.util.Stack;

public class NestedBrackets {
	
	public int solution(String S) {
		Stack<String> stack = new Stack<>();
		for (char c: S.toCharArray()) {
			if (c == '(') {
				stack.push("(");
			} 
			
			if (c == ')') {
				if (stack.isEmpty()) {
					return 0;
				}
				stack.pop();
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}
	
	public static void main(String args[]) {
		NestedBrackets nsBrackets = new NestedBrackets();
		System.out.println(nsBrackets.solution(""));
	}

}
