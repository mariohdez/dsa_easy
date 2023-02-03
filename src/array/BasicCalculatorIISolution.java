package array;

import java.util.Stack;

public class BasicCalculatorIISolution {
	public int calculate(String s) {
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		char currentOperation = '+';
		int currentNumber = 0;

		for (int i = 0; i < s.length(); ++i) {
			char currentChar = s.charAt(i);

			if (Character.isDigit(currentChar)) {
				currentNumber = currentNumber * 10 + (currentChar - '0');
			}

			if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
				if (currentOperation == '+') {
					stack.push(currentNumber);
				} else if (currentOperation == '-') {
					stack.push(-currentNumber);
				} else if (currentOperation == '*') {
					stack.push(stack.pop() * currentNumber);
				} else if (currentOperation == '/') {
					stack.push(stack.pop() / currentNumber);
				}

				currentOperation = currentChar;
				currentNumber = 0;
			}
		}

		while (!stack.isEmpty()) {
			result += stack.pop();
		}

		return result;
	}
}
