package dsa_easy;

import array.IntegerToRomanSolution;

public class Program {
	public static void main(String[] args) {
		int num = 2994;

		var test = new IntegerToRomanSolution();

		var hi = test.intToRoman(num);
		
		System.out.println("roman: " + hi);
		return; // LVIII
	}
}
