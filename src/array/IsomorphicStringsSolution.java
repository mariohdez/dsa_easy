package array;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
public class IsomorphicStringsSolution {

	public boolean isIsomorphic(String s, String t) {
		Set<Character> charactersThatHaveBeenMapped = new HashSet<Character>();
		Map<Character, Character> characterMapping = new HashMap<Character, Character>();

		for (int i = 0; i < s.length(); ++i) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);

			if (!characterMapping.containsKey(sChar)) {
				if (charactersThatHaveBeenMapped.contains(tChar)) {
					return false;
				}

				characterMapping.put(sChar, tChar);
				charactersThatHaveBeenMapped.add(tChar);
				continue;
			} else {
				char mappedChar = characterMapping.get(sChar);
				
				if (mappedChar != tChar) {
					return false;
				}
			}
		}

		return true;
	}
}
