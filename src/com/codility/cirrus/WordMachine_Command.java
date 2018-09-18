package com.codility.cirrus;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class WordMachine_Command {
	
	public static final int ERROR = -1;
	public static int MIN_ELEMENT = 0;
	public static int MAX_ELEMENT = 1048575;

	private Stack<Integer> wordMachine = new Stack<>();
	private Map<String, Runnable> map = new HashMap<>(); 
	
	public int solution(String S) {

		if (S.length() < 0 || S.length() > 2000) {
			return ERROR;
		}
		
		map.put("POP", this::pop);
		map.put("DUP", this::duplicate);
		map.put("+", this::add);
		map.put("-", this::subtract);
		
		for (String element : S.split(" ")) {
			try {
				map.getOrDefault(element, () -> push(element)).run();
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
		
		int first = wordMachine.pop();
		int second = wordMachine.pop();
		int diff = first - second;

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
		
		int first = wordMachine.pop();
		int second = wordMachine.pop();
		int sum = first + second;

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
		WordMachine_Command wordMachine = new WordMachine_Command();
		System.out.println(wordMachine.solution("1048575, 1048574, +"));
	}

}
