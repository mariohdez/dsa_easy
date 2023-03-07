package array;

public class LongestCommonPrefixSolution {
	public String longestCommonPrefix(String[] strs) {
		StringBuilder strBuilder = new StringBuilder();
		int shortestWordLength = Integer.MAX_VALUE;
		int pointer = 0;
		char curChar = 'a';

		for (int i = 0; i < strs.length; ++i) {
			if (strs[i].length() < shortestWordLength) {
				shortestWordLength = strs[i].length();
			}
		}

		while (pointer < shortestWordLength) {
			curChar = strs[0].charAt(pointer);

			for (int i = 0; i < strs.length; ++i) {
				if (curChar != strs[i].charAt(pointer)) {
					return strBuilder.toString();
				}
			}

			strBuilder.append(curChar);
			pointer++;
		}

		return strBuilder.toString();
	}
}
