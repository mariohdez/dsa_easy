package array;

import java.util.Map;
import java.util.LinkedHashMap;

public class LengthOfLongestSubstringKDistinctSolution {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s.length() * k == 0) return 0;
		int left = 0;
		int right = 0;
		int maxLength = 1;
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		while (right < s.length()) {
			char c = s.charAt(right);

			if (map.containsKey(c)) {
				map.remove(c);
			}

			map.put(c, right);
			right++;

			if (map.size() == k + 1) {
				var leftMost = map.entrySet().iterator().next();

				map.remove(leftMost.getKey());
				left = leftMost.getValue() + 1;
			}

			maxLength = Math.max(maxLength, right - left);
		}

		return maxLength;
	}
}
