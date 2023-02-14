package dsa_easy;

import array.StringCompressionSolution;

public class Program {
	public static void main(String[] args) {
		StringCompressionSolution scs = new StringCompressionSolution();
		char[] chars = new char[] {'a', 'a', 'a', 'b'};
		int newLen = scs.compress(chars);

		System.out.println("new len: " + newLen);
		return;
	}
}
