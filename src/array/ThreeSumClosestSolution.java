package array;

import java.util.Arrays;

public class ThreeSumClosestSolution {

    public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		Integer closestDistance = Integer.MAX_VALUE;
		int closestTarget = 0;

		for (int i = 0; i < nums.length; ++i) {
			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];

				if (Math.abs(target-sum) < Math.abs(closestDistance)) {
					closestDistance = target-sum;
					closestTarget = sum;
				}

				if (sum == target) {
					return sum;
				} else if (sum > target) {
					--k;
				} else {
					++j;
				}
			}
		}

		return closestTarget;
    }

}
