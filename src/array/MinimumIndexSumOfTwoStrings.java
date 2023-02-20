package array;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MinimumIndexSumOfTwoStrings {
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> list1Words = new HashMap<String, Integer>();
		Map<String, Integer> list2Words = new HashMap<String, Integer>();
		Map<String, Integer> smallerMap;
		Map<String, Integer> largerMap;
		List<String> answer = new ArrayList<String>();

		for (int i = 0; i < list1.length; ++i) {
			list1Words.put(list1[i], i);
 		}

		for (int i = 0; i < list2.length; ++i) {
			list2Words.put(list2[i], i);
		}

		if (list1Words.size() < list2Words.size()) {
			smallerMap = list1Words;
			largerMap = list2Words;
		} else {
			smallerMap = list2Words;
			largerMap = list1Words;
		}

		Map<String, List<Integer>> commonWordsToIndiciesMap = new HashMap<String, List<Integer>>();

		for (Map.Entry<String, Integer> entry : smallerMap.entrySet()) {
			if (largerMap.containsKey(entry.getKey())) {
				List<Integer> indicies = new ArrayList<Integer>();
				indicies.add(entry.getValue());
				indicies.add(largerMap.get(entry.getKey()));
				commonWordsToIndiciesMap.put(entry.getKey(), indicies);
			}
		}

		int smallestSum = Integer.MAX_VALUE;

		for (Map.Entry<String, List<Integer>> entry : commonWordsToIndiciesMap.entrySet()) {
			int curSum = entry.getValue().get(0) + entry.getValue().get(1);

			if (curSum < smallestSum) {
				smallestSum = curSum;
			}
		}

		for (Map.Entry<String, List<Integer>> entry : commonWordsToIndiciesMap.entrySet()) {
			int curSum = entry.getValue().get(0) + entry.getValue().get(1);

			if (curSum == smallestSum) {
				answer.add(entry.getKey());
			}
		}

		String[] arrayAnswer = new String[answer.size()];

		for (int i = 0; i < answer.size(); ++i) {
			arrayAnswer[i] = answer.get(i);
		}

		return arrayAnswer;
	}
}
