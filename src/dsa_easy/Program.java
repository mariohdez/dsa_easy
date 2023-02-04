package dsa_easy;

import array.MinimumWindowSubstringSolution;

public class Program {
	public static void main(String[] args) {
		/*
		 * "bdab"
"ab"
		 * */
		var s = "ADOBECODEBANC";
		var t = "ABC";

		var test = new MinimumWindowSubstringSolution();

		var hi = test.minWindow(s,t);
		
		System.out.println("Max Len: " + hi);
		return;
	}
}
