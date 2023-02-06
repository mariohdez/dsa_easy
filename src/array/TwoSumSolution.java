package array;

import java.util.Map;
import java.util.HashMap;

public class TwoSumSolution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> valueToIndexMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; ++i) {
			int compliment = target - nums[i];

			if (valueToIndexMap.containsKey(compliment)) {
				return new int[] { i, valueToIndexMap.get(compliment) };
			}

			valueToIndexMap.put(nums[i], i);
		}

		return null;
	}
}
