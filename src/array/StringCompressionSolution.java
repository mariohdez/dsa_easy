package array;

public class StringCompressionSolution {
	public int compress(char[] chars) {
		int readerPtr = 0;
		int writerPtr = 0;
		int N = chars.length;

		while (readerPtr < N) {
			char currentChar = chars[readerPtr];
			int start = readerPtr;

			while (readerPtr < N && chars[readerPtr] == currentChar) {
				readerPtr++;
			}

			int numberOfConsequitiveSameChars = readerPtr - start;

			chars[writerPtr] = currentChar;
			writerPtr++;

			String numberOfConsqCharsStr = String.valueOf(numberOfConsequitiveSameChars);

			if (numberOfConsequitiveSameChars != 1) {
				for (char d : numberOfConsqCharsStr.toCharArray()) {
					chars[writerPtr] = d;
					writerPtr++;
				}
			}
		}

		return writerPtr;
	}
}
