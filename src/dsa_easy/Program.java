package dsa_easy;

import array.LengthOfLongestSubstringKDistinctSolution;

public class Program {
	public static void main(String[] args) {
		var test = new LengthOfLongestSubstringKDistinctSolution();

		var hi = test.lengthOfLongestSubstringKDistinct("aa", 1);
		
		System.out.println("Max Len: " + hi);
		return;
	}
}
