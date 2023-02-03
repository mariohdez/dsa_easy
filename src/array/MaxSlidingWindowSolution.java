package array;

import java.util.ArrayDeque;

public class MaxSlidingWindowSolution {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length * k == 0) return new int[0];
		if (k == 1) return nums;

		int left = 0;
		int right = 0;
		int[] output = new int[nums.length - k + 1];
		int outputPtr = 0;
		ArrayDeque<Integer> dequeue = new ArrayDeque<Integer>();

		while (right < nums.length) {
			while (!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[right]) {
				dequeue.removeLast();
			}

			dequeue.addLast(right);
			
			if (left > dequeue.peekFirst()) {
				dequeue.removeFirst();
			}

			if (right + 1 >= k) {
				output[outputPtr] = nums[dequeue.getFirst()];
				outputPtr++;
				left++;
			}

			right++;
		}

		return output;
	}
}
