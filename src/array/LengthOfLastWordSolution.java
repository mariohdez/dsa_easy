package array;

public class LengthOfLastWordSolution {
	public int lengthOfLastWord(String s) {
		int ptr = 0;
		int N = s.length();
		int lengthOfPreviousWord = 0;
		int startOfCurrentWord = 0;

		while (ptr < N) {
			while (ptr < N && Character.isWhitespace(s.charAt(ptr))) {
				++ptr;
			}

			if (ptr >= N) {
				return lengthOfPreviousWord;
			}

			startOfCurrentWord = ptr;

			while (ptr < N && !Character.isWhitespace(s.charAt(ptr))) {
				ptr++;
			}

			lengthOfPreviousWord = ptr - startOfCurrentWord;
		}

		return lengthOfPreviousWord;
	}
}
