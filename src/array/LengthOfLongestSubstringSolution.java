package array;

import java.util.Map;
import java.util.HashMap;

public class LengthOfLongestSubstringSolution {
	public int lengthOfLongestSubstring(String s) {
		int longestSubstringLength = 0;
		int left = 0;
		int right = 0;
		Map<Character, Integer> letterFrequencyMap = new HashMap<Character, Integer>();

		while (right < s.length()) {
			char c = s.charAt(right);

			Integer freq = letterFrequencyMap.getOrDefault(Character.valueOf(c), Integer.valueOf(0));
			letterFrequencyMap.put(Character.valueOf(c), Integer.valueOf(freq.intValue() + 1));

			while (letterFrequencyMap.get(Character.valueOf(c)) > 1) {
				letterFrequencyMap.put(
							Character.valueOf(s.charAt(left)),
							letterFrequencyMap.get(Character.valueOf(s.charAt(left))) - 1);
				left++;
			}

			longestSubstringLength = Math.max(longestSubstringLength, right - left + 1);

			right++;
		}

		return longestSubstringLength;
	}
}
