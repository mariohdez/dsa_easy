package array;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MissingRangesSolution {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> answer = new ArrayList<String>();
		List<List<Integer>> missingRanges = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			answer.add(getRangeInStringFormat(Arrays.asList(lower, upper)));
			return answer;
		}

		int res = nums[0] - lower;

		if (res > 0) {
			missingRanges.add(Arrays.asList(lower, nums[0] - 1));
		}

		for (int i = 1; i < nums.length; ++i) {
			res = nums[i] - nums[i - 1];

			if (res > 1) {
				missingRanges.add(Arrays.asList(nums[i - 1] + 1, nums[i] - 1));
			}
		}

		res = upper - nums[nums.length - 1];

		if (res > 0) {
			missingRanges.add(Arrays.asList(nums[nums.length - 1] + 1, upper));
		}

		for (List<Integer> range : missingRanges) {
			answer.add(getRangeInStringFormat(range));
		}

		return answer;
	}

	public String getRangeInStringFormat(List<Integer> range) {
		StringBuilder strBuilder = new StringBuilder();
		int difference = range.get(1) - range.get(0);

		if (difference == 0) {
			strBuilder.append(range.get(0));
		} else {
			strBuilder.append(range.get(0));
			strBuilder.append("->");
			strBuilder.append(range.get(1));
		}

		return strBuilder.toString();
	}
}
