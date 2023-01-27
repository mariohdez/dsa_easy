package dsa_easy;

import array.LongestPalindromeSolution;

public class Program {
	public static void main(String[] args) {
		String s = "aaaaa";
		LongestPalindromeSolution test = new LongestPalindromeSolution();
		
		String value = test.longestPalindrome(s);
		
		System.out.println(value);
	}
}
