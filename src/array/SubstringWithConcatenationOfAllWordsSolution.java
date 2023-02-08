package array;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWordsSolution {
	private Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
	private int n;
	private int k;
	private int wordLength;
	private int substringSize;

	private void slidingWindow(String s, int left, List<Integer> indicies) {
		Map<String, Integer> wordsFound = new HashMap<String, Integer>();
		int wordsUsed = 0;
		boolean excessWords = false;

		for (int right = left; right <= n - wordLength; right += wordLength) {
			String chunk = s.substring(right, right + wordLength);

			if (!this.wordCountMap.containsKey(chunk)) {
				wordsFound.clear();
				excessWords = false;
				wordsUsed = 0;
				left = right + wordLength;
				continue;
			} else {
				while (right - left == substringSize || excessWords) {
					String leftMostString = s.substring(left, left + wordLength);
					left += wordLength;

					wordsFound.put(leftMostString, wordsFound.getOrDefault(leftMostString, 0) - 1);

					if (wordsFound.get(leftMostString) >= wordCountMap.get(leftMostString)) {
						excessWords = false;
					} else {
						wordsUsed--;
					}
				}

				wordsFound.put(chunk, wordsFound.getOrDefault(chunk, 0) + 1);

				if (wordsFound.get(chunk) <= wordCountMap.get(chunk)) {
					wordsUsed++;
				} else {
					excessWords = true;
				}


				if (wordsUsed == k && !excessWords) {
					indicies.add(left);
				}
			}
		}

	}


	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> startIndicies = new ArrayList<Integer>();
		n = s.length();
		k = words.length;
		wordLength = words[0].length();
		substringSize = wordLength * k;

		for (String word : words) {
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}

		for (int i = 0; i < wordLength; ++i) {
			slidingWindow(s, i, startIndicies);
		}

		return startIndicies;
	}
}
