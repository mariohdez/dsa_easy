package array;

import java.util.List;
import java.util.ArrayList;

public class FindAllNumbersDisappearedInAnArraySolution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> disappearedNumbers = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; ++i) {
			int mappingIndex = Math.abs(nums[i]) - 1;
			nums[mappingIndex] = Math.abs(nums[mappingIndex]) * -1;
		}


		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] > 0) {
				disappearedNumbers.add(i+1);
			}
		}

		return disappearedNumbers;
    }
}
