package com.codility.cirrus;

import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

public class WordMachine_Enum {
	public static final int ERROR = -1;
	public static int MIN_ELEMENT = 0;
	public static int MAX_ELEMENT = 1048575;

	private static Stack<Integer> wordMachine = new Stack<>();

	private enum OperationTypes {
		POP("POP") {
			@Override
			public void doOperation() throws Exception {
				if (wordMachine.isEmpty()) {
					throw new IllegalArgumentException(
							"Stack is empty or does not have required " + "number of elements to perform operation");
				}

				wordMachine.pop();
			}
		},
		DUP("DUP") {
			@Override
			public void doOperation() throws Exception {
				if (wordMachine.isEmpty()) {
					throw new IllegalArgumentException(
							"Stack is empty or does not have required " + "number of elements to perform operation");
				}

				int peek = wordMachine.peek();
				wordMachine.push(peek);
			}
		},
		ADD("+") {
			@Override
			public void doOperation() throws Exception {
				if (wordMachine.isEmpty() || wordMachine.size() < 2) {
					throw new IllegalArgumentException(
							"Stack is empty or does not have required " + "number of elements to perform operation");
				}

				int a = wordMachine.pop();
				int b = wordMachine.pop();
				int sum = a + b;

				if (sum < MIN_ELEMENT || sum > MAX_ELEMENT) {
					throw new IllegalArgumentException("Accepted int range is 0 .. 2 pow 20 -1");
				}

				wordMachine.push(sum);
			}
		},
		SUB("-") {
			@Override
			public void doOperation() throws Exception {
				if (wordMachine.isEmpty() || wordMachine.size() < 2) {
					throw new IllegalArgumentException(
							"Stack is empty or does not have required " + "number of elements to perform operation");
				}

				int a = wordMachine.pop();
				int b = wordMachine.pop();
				int diff = a - b;

				if (diff < MIN_ELEMENT || diff > MAX_ELEMENT) {
					throw new IllegalArgumentException("Accepted int range is 0 .. 2 pow 20 -1");
				}

				wordMachine.push(diff);
			}
		};

		private String op;

		private OperationTypes(String op) {
			this.op = op;
		}

		public String getOp() {
			return op;
		}

		public static Optional<OperationTypes> getEnum(String op) {
			return Arrays.stream(OperationTypes.values())
					.filter(operation -> op.equals(operation.getOp()))
					.findFirst();
		}

		public abstract void doOperation() throws Exception;
	}

	public int solution(String S) {

		if (S.length() < 0 || S.length() > 2000) {
			return ERROR;
		}
		
		for (String element : S.split(" ")) {
			try {
				Optional<OperationTypes> optional = OperationTypes.getEnum(element);
				if (!optional.isPresent()) {
					push(element);
				} else {
					optional.get().doOperation();
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

	public static void main(String args[]) {
		WordMachine_Enum wordMachine = new WordMachine_Enum();
		System.out.println(wordMachine.solution("1048575, 1048574, +"));
	}

}
