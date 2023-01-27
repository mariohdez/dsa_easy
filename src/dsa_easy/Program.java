package dsa_easy;

import array.LengthOfLongestSubstringSolution;

public class Program {
	public static void main(String[] args) {
		String s = "pwwkew";
		LengthOfLongestSubstringSolution test = new LengthOfLongestSubstringSolution();
		
		int value = test.lengthOfLongestSubstring(s);
		
		System.out.println(value);
	}
}
