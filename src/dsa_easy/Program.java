package dsa_easy;

import array.LongestCommonPrefixSolution;

public class Program {
	public static void main(String[] args) {
		LongestCommonPrefixSolution lcps = new LongestCommonPrefixSolution();
		String[] strs = new String[] {"dog","racecar","car"};
		String prefix = lcps.longestCommonPrefix(strs);

		System.out.println("prefix: " + prefix);

		return;
	}
}
