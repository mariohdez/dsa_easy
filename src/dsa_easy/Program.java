package dsa_easy;

import array.MissingRangesSolution;

public class Program {
	public static void main(String[] args) {
		int[] nums = new int[] {0,1,3,50,75};
		
		MissingRangesSolution test = new MissingRangesSolution();
		
		var value = test.findMissingRanges(nums, 0, 99);
		
		System.out.println(value);
	}
}
