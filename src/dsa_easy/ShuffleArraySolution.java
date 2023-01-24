package dsa_easy;

import java.util.Random;

public class ShuffleArraySolution {
	private Random random;
	private int[] original;
	private int[] array;

	public ShuffleArraySolution(int[] nums) {
		this.random = new Random();
		this.original = nums.clone();
		this.array = nums.clone();
	}

	public int[] reset() {
		return this.array;
	}

	public int[] shuffle() {
		return this.array;
	}
}
