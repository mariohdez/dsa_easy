package array;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class WordPatternSolution {
	public boolean wordPattern(String pattern, String s) {
		String[] elements = s.split(" ");

		if (pattern.length() != elements.length) {
			return false;
		}

		Map<Character, String> charToWordMapping = new HashMap<Character, String>();
		Set<Character> hasCharBeenMapped = new HashSet<Character>();
		Set<String> hasElementBeenMapped = new HashSet<String>();

		for (int i = 0; i < pattern.length(); ++i) {
			char c = pattern.charAt(i);
			String element = elements[i];

			if (!hasCharBeenMapped.contains(c)) {
				if (hasElementBeenMapped.contains(element)) {
					return false;
				}
				charToWordMapping.put(c, element);
				hasCharBeenMapped.add(c);
				hasElementBeenMapped.add(element);
			} else {
				String mappedElement = charToWordMapping.get(c);

				if (!element.equals(mappedElement)) {
					return false;
				}
			}
		}

		return true;
	}
}
