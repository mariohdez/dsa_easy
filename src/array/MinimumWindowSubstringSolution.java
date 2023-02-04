package array;

import java.util.Map;
import java.util.HashMap;

public class MinimumWindowSubstringSolution {

	public String minWindow(String s, String t) {
		if (t.length() == 0 || s.length() == 0)
			return "";

		Integer minWindowLength = null;

		int left = 0;
		int right = 0;
		int have = 0;
		int need = 0;
		Map<Character, Integer> tMap = new HashMap<Character, Integer>();
		Map<Character, Integer> window = new HashMap<Character, Integer>();
		String substr = "";

		for (int i = 0; i < t.length(); ++i) {
			char c = t.charAt(i);
			int freq = tMap.getOrDefault(c, 0);
			tMap.put(c, freq + 1);
		}

		need = tMap.size();

		while (right < s.length()) {
			char c = s.charAt(right);
			int freq = window.getOrDefault(c, 0);
			window.put(c, freq + 1);

			if (tMap.containsKey(c) && window.get(c).intValue() == tMap.get(c).intValue()) {
				have++;
			}

			while (left <= right && have == need) {
				if (minWindowLength == null || right - left + 1 < minWindowLength.intValue()) {
					minWindowLength = right - left + 1;
					substr = s.substring(left, right + 1);
				}

				char leftChar = s.charAt(left);

				window.put(leftChar, window.get(leftChar) - 1);

				if (tMap.containsKey(leftChar) && window.get(leftChar) < tMap.get(leftChar)) {
					have--;
				}

				left++;
			}

			right++;
		}
		
		if (minWindowLength == null) {
			return "";
		}

		return substr;
	}
}
