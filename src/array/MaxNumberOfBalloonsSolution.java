package array;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class MaxNumberOfBalloonsSolution {
	public int maxNumberOfBalloons(String text) {
		if (text.length() == 0) return 0;

		String balloon = "balloon";
		Set<Character> balloonLetterSet = new HashSet<Character>();
		Map<Character, Integer> balloonLetterCountMap = new HashMap<Character, Integer>();

		for (int i = 0; i < balloon.length(); ++i) {
			char c = balloon.charAt(i);

			balloonLetterSet.add(c);
			balloonLetterCountMap.put(c, 0);
		}


		for (int i = 0; i < text.length(); ++i) {
			char c = text.charAt(i);

			if (!Character.isLetter(c)) {
				continue;
			}

			if (!balloonLetterSet.contains(c)) {
				continue;
			}

			balloonLetterCountMap.put(c, balloonLetterCountMap.getOrDefault(c, 0) + 1);
		}

		int minCount = Integer.MAX_VALUE;
		balloonLetterCountMap.put('l', balloonLetterCountMap.get('l') / 2);
		balloonLetterCountMap.put('o', balloonLetterCountMap.get('o') / 2);
		for (Map.Entry<Character, Integer> entry : balloonLetterCountMap.entrySet()) {
			if (entry.getValue() < minCount) {
				minCount = entry.getValue();
			}
		}

		if (minCount == Integer.MAX_VALUE) return 0;
		

		return minCount;
	}
}
