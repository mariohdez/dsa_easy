package array;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ThreeSumSolution {
	private List<List<Integer>> answers = new ArrayList<List<Integer>>();

	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);

		for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
			if (i == 0 || nums[i - 1] != nums[i]) {
				twoSum(nums, i);
			}
		}

		return answers;
	}

	public void twoSum(int[] nums, int i) {
		int target = -1 * nums[i];
		Map<Integer, Integer> valueToIndexMap = new HashMap<Integer, Integer>();

		for (int j = i + 1; j < nums.length; ++j) {
			int remainingValue = target - nums[j];

			if (valueToIndexMap.containsKey(remainingValue)) {
				this.answers.add(Arrays.asList(nums[i], nums[j], remainingValue));

				while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
					j++;
				}
			} else {
				valueToIndexMap.put(nums[j], j);
			}
		}
	}
}

