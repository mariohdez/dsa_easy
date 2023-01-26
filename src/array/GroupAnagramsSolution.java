package array;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class GroupAnagramsSolution {
	private List<List<String>> answer = new ArrayList<List<String>>();
	private Map<String, List<String>> anagramCodeToWordsMap = new HashMap<String, List<String>>();

	public List<List<String>> groupAnagrams(String[] strs) {
		for (String word : strs) {
			String anagramCode = constructAnagramCode(word);

			if (!this.anagramCodeToWordsMap.containsKey(anagramCode)) {
				this.anagramCodeToWordsMap.put(
					anagramCode, new ArrayList<String>(Arrays.asList(word)));
			} else {
				this.anagramCodeToWordsMap.get(anagramCode).add(word);
			}
		}

		for (Map.Entry<String, List<String>> entry : this.anagramCodeToWordsMap.entrySet()) {
			this.answer.add(entry.getValue());
		}

		return this.answer;
	}

	private String constructAnagramCode(String word) {
		StringBuilder strBuilder = new StringBuilder();
		int[] letterFrequencyCountMap = new int[26];
		Arrays.fill(letterFrequencyCountMap, 0);

		for (int i = 0; i < word.length(); ++i) {
			letterFrequencyCountMap[word.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; ++i) {
			strBuilder.append("#" + String.valueOf(letterFrequencyCountMap[i]));
		}

		return strBuilder.toString();
	}
}
