package array;

import java.util.Map;
import java.util.HashMap;

public class FourSumCountSolution {
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;

		for (int a : nums1) {
			for (int b : nums2) {
				map.put(a+b, map.getOrDefault(a + b, 0) + 1);
			}
		}

		for (int c : nums3) {
			for (int d : nums4) {
				count += map.getOrDefault(-1 * (c + d), 0);
			}
		}

		return count;
	}
}
