package array;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PositionOfLargeGroupsSolution {
	public List<List<Integer>> largeGroupPositions(String s) {
		int left = 0;
		int right = 1;
		List<List<Integer>> groups = new ArrayList<List<Integer>>();
		char previousLetter = s.charAt(0);

		while (right < s.length()) {
			char currentLetter = s.charAt(right);

			if (previousLetter == currentLetter) {
				if (right == s.length() - 1 && (right - left + 1) >= 3) {
					groups.add(new ArrayList<Integer>(Arrays.asList(left, right)));
				}

				right++;
				continue;
			} else {
				if (right - left >= 3) {
					groups.add(new ArrayList<Integer>(Arrays.asList(left, right - 1)));
				}

				previousLetter = currentLetter;
				left = right;
				right++;
			}
		}

		return groups;
	}
}
