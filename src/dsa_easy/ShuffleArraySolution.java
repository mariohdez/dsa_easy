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
		this.array = original.clone();

		return this.array;
	}

	public int[] shuffle() {
		for (int i = 0; i < this.array.length; ++i) {
			int index = this.random.nextInt(this.array.length - i) + i;
			swap(this.array, i, index);
		}

		return this.array;
	}

	public void swap(int[] nums, int indexA, int indexB) {
		int temp = nums[indexA];
		nums[indexA] = nums[indexB];
		nums[indexB] = temp;
	}
}
