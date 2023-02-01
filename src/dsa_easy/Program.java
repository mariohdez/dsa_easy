package dsa_easy;

import array.FirstMissingPositiveSolution;

public class Program {
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 0};

		var test = new FirstMissingPositiveSolution();

		var hi = test.firstMissingPositive(nums);
		System.out.println("hi: " + hi);
	}
}
