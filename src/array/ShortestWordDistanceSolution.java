package array;

public class ShortestWordDistanceSolution {
	public int shortestDistance(String[] wordDict, String word1, String word2) {
		int w1i = -1;
		int w2i = -1;
		int minDistance = Integer.MAX_VALUE;

		for (int i = 0; i < wordDict.length; ++i) {
			String w = wordDict[i];

			if (w.equals(word1))
				w1i = i;

			if (w.equals(word2))
				w2i = i;

			if (w1i != -1 && w2i != -1) {
				minDistance = Math.min(minDistance, Math.abs(w1i - w2i));
			}
		}

		return minDistance;
	}
}
