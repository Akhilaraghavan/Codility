package com.codility.cirrus;

import java.util.Stack;

public class WordMachine {

	public static final int ERROR = -1;
	public static int MIN_ELEMENT = 0;
	public static int MAX_ELEMENT = 1048575;

	private Stack<Integer> wordMachine = new Stack<>();

	public int solution(String S) {

		if (S.length() < 0 || S.length() > 2000) {
			return -1;
		}
		
		for (String element : S.split(" ")) {
			try {
				switch (element) {
					case "POP": pop();
								break;
				    case "DUP": duplicate();
					            break;
				    case "+":   add();
				                break;
				    case "-":   subtract();
					            break;
				    default:    push(element);
				}
			} catch (Throwable e) {
				return ERROR;
			}
		}

		return wordMachine.isEmpty() ? ERROR :  wordMachine.pop();
	}

	private void push(String element) {
		int x = Integer.valueOf(element);
		if (x < MIN_ELEMENT || x > MAX_ELEMENT) {
			throw new IllegalArgumentException("Accepted int range is 0 .. 2 pow 20 -1");
		}
		wordMachine.push(x);
	}

	private void subtract() {
		if (wordMachine.isEmpty() || wordMachine.size() < 2) {
			throw new IllegalArgumentException("Stack is empty or does not have required "
					+ "number of elements to perform operation");
		}
		
		int a = wordMachine.pop();
		int b = wordMachine.pop();
		int diff = a - b;

		if (diff < MIN_ELEMENT || diff > MAX_ELEMENT) {
			throw new IllegalArgumentException("Accepted int range is 0 .. 2 pow 20 -1");
		}
		
		wordMachine.push(diff);
	}

	private void add() {
		if (wordMachine.isEmpty() || wordMachine.size() < 2) {
			throw new IllegalArgumentException("Stack is empty or does not have required "
					+ "number of elements to perform operation");
		}
		
		int a = wordMachine.pop();
		int b = wordMachine.pop();
		int sum = a + b;

		if (sum < MIN_ELEMENT || sum > MAX_ELEMENT) {
			throw new IllegalArgumentException("Accepted int range is 0 .. 2 pow 20 -1");
		}
		
		wordMachine.push(sum);
	}

	private void duplicate() {
		if (wordMachine.isEmpty()) {
			throw new IllegalArgumentException("Stack is empty or does not have required "
					+ "number of elements to perform operation");
		}
		
		int peek = wordMachine.peek();
		wordMachine.push(peek);
	}

	private void pop() {
		if (wordMachine.isEmpty()) {
			throw new IllegalArgumentException("Stack is empty or does not have required "
					+ "number of elements to perform operation");
		}
		
		wordMachine.pop();
	}
	
	
	public static void main(String args[]) {
		WordMachine wordMachine = new WordMachine();
		System.out.println(wordMachine.solution("1048575, 1048574, +"));
	}

}
