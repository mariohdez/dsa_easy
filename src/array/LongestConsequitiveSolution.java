package array;

import java.util.Set;
import java.util.HashSet;

public class LongestConsequitiveSolution {
	public int longestConsequitive(int[] nums) {
		int longest = 0;
		Set<Integer> numSet = new HashSet<Integer>();
		Set<Integer> seen = new HashSet<Integer>();

		for (int i = 0; i < nums.length; ++i) {
			numSet.add(nums[i]);
		}

		for (int i : numSet) {
			if (seen.contains(i)) {
				continue;
			}

			int startingPoint = i;
			int count = 0;

			while (numSet.contains(startingPoint)) {
				startingPoint--;
				count++;
				seen.add(startingPoint);
			}

			startingPoint = i + 1;

			while (numSet.contains(startingPoint)) {
				startingPoint++;
				count++;
				seen.add(startingPoint);
			}

			longest = Math.max(longest, count);
		}

		return longest;
	}
}
