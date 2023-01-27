package array;

import java.util.Set;
import java.util.HashSet;

public class LongestPalindromeSolution {
	public String longestPalindrome(String s) {
		String longestPalindromeStr = "";
		int longestPalindromeLength = 0;
		Set<String> palindromes = new HashSet<String>();
		StringBuilder strBuilder;

		for (int i = 0; i < s.length(); ++i) {
			strBuilder = new StringBuilder();
			strBuilder.append(s.charAt(i));
			String str = strBuilder.toString();

			if (!palindromes.contains(str)) {
				palindromes.add(str);
				if (1 > longestPalindromeLength) {
					longestPalindromeLength = 1;
					longestPalindromeStr = s.substring(i, i+1);
				}
			}

			if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				strBuilder.append(s.charAt(i));
				str = strBuilder.toString();

				if (!palindromes.contains(str)) {
					if (2 > longestPalindromeLength) {
						longestPalindromeLength = 2;
						longestPalindromeStr = s.substring(i, i + 2);
					}
					palindromes.add(str);
				}
			}
		}

		for (int i = 1; i < s.length(); ++i) {
			int left = i - 1;
			int right = i + 1;

			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				int len = right - left + 1;
				if (len > longestPalindromeLength) {
					longestPalindromeLength = len;
					longestPalindromeStr = s.substring(left, right + 1);
				}

				left--;
				right++;
			}
		}

		for (int i = 1, j = 2; j < s.length(); ++i, j++) {
			int left = i - 1;
			int right = j + 1;
			String possiblePalindrome = s.substring(i, right);

			if (!palindromes.contains(possiblePalindrome)) {
				continue;
			}

			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				int len = right - left + 1;

				if (len > longestPalindromeLength) {
					longestPalindromeLength = len;
					longestPalindromeStr = s.substring(left, right + 1);
				}

				left--;
				right++;
			}
		}

		return longestPalindromeStr;
	}
}
