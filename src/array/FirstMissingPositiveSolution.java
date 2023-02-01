package array;

public class FirstMissingPositiveSolution {
	public int firstMissingPositive(int[] nums) {

		int containsOne = 0;

		int n = nums.length;

		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 1) {
				containsOne++;
				break;
			}
		}

		if (containsOne == 0) {
			return 1;
		}

		for (int i = 0; i < n; ++i) {
			if (nums[i] <= 0 || nums[i] > n) {
				nums[i] = 1;
			}
		}

		for (int i = 0; i < n; ++i) {
			int a = Math.abs(nums[i]);

			if (a == n) {
				nums[0] = -1 * Math.abs(nums[0]);
			} else {
				nums[a] = -1 * Math.abs(nums[a]);
			}
		}

		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] > 0) {
				return i;
			}
		}

		if (nums[0] > 0) {
			return n;
		}

		return n + 1;
	}
}
