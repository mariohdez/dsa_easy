package array;

public class RemoveElementSolution {
	public int removeElement(int[] nums, int val) {
		int reader = 0;
		int writer = 0;

		while (reader < nums.length) {
			if (nums[reader] != val) {
				nums[writer] = nums[reader];
				reader++;
				writer++;
			} else {
				reader++;
			}
		}

		return writer;
	}
}
