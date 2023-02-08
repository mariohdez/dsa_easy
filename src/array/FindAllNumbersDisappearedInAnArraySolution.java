package array;

import java.util.List;
import java.util.ArrayList;

public class FindAllNumbersDisappearedInAnArraySolution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> disappearedNumbers = new ArrayList<Integer>();
		int n = nums.length;

		for (int i = 0; i < n; ++i) {
			int idx = Math.abs(nums[i]) - 1;

			if (nums[idx] > 0) {
				nums[idx] *= -1;
			}
		}


		for (int i = 1; i <= n; ++i) {
			if (nums[i - 1] > 0) {
				disappearedNumbers.add(i);
			}
		}

		return disappearedNumbers;
    }
}
