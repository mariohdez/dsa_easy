package array;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSumSolution {
	private List<List<Integer>> answers = new ArrayList<List<Integer>>();

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);

		for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				twoSum(nums, i);
			}
		}

		return this.answers;
	}

	public void twoSum(int[] nums, int i) {
		int low = i + 1;
		int high = nums.length - 1;

		while (low < high) {
			int sum = nums[i] + nums[low] + nums[high];

			if (sum < 0) {
				low++;
			} else if (sum > 0) {
				high--;
			} else {
				this.answers.add(Arrays.asList(nums[i], nums[low], nums[high]));
				low++;
				high--;
				while (low < high && nums[low - 1] == nums[low]) {
					low++;
				}
			}
		}
	}
}

