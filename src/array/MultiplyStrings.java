package array;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) return "0";
		String largeNum;
		String smallNum;
		int smallNumPointer;
		int multiplier = 0;
		String result = "0";

		if (num1.length() > num2.length()) {
			largeNum = num1;
			smallNum = num2;
		} else {
			largeNum = num2;
			smallNum = num1;
		}

		smallNumPointer = smallNum.length() - 1;

		while (smallNumPointer > -1) {
			String curDigitResult = multiplyNumByDigit(largeNum, smallNum.charAt(smallNumPointer) - '0');

			for (int i = 0; i < multiplier; ++i) {
				curDigitResult = curDigitResult + "0";
			}

			result = addTwoNumbers(result, curDigitResult);

			smallNumPointer--;
			multiplier++;
		}

		return result;
	}

	private String addTwoNumbers(String num1, String num2) {
		StringBuilder strBuilder = new StringBuilder();
		String largeNum;
		String smallNum;

		if (num1.length() > num2.length()) {
			largeNum = num1;
			smallNum = num2;
		} else {
			largeNum = num2;
			smallNum = num1;
		}

		int largeNumPtr = largeNum.length() - 1;
		int smallNumPtr = smallNum.length() - 1;
		int carryOver = 0;

		while (smallNumPtr > -1) {
			int tempRes = (largeNum.charAt(largeNumPtr) - '0') + (smallNum.charAt(smallNumPtr) - '0') + carryOver;

			strBuilder.insert(0, tempRes % 10);
			carryOver = tempRes / 10;

			smallNumPtr--;
			largeNumPtr--;
		}

		while (largeNumPtr > -1) {
			int tempRes = (largeNum.charAt(largeNumPtr) - '0') + carryOver;

			strBuilder.insert(0, tempRes % 10);
			carryOver = tempRes / 10;

			largeNumPtr--;
		}

		if (carryOver > 0) {
			strBuilder.insert(0, carryOver);
		}

		return strBuilder.toString();
	}

	private String multiplyNumByDigit(String num, int digit) {
		int numPtr = num.length() - 1;
		int carryOver = 0;
		StringBuilder strBuilder = new StringBuilder();

		while (numPtr > -1) {
			int topDigit = num.charAt(numPtr) - '0';

			int tempRes = topDigit * digit + carryOver;

			strBuilder.insert(0, tempRes % 10);

			carryOver = tempRes / 10;

			numPtr--;
		}

		if (carryOver > 0) {
			strBuilder.insert(0, carryOver);
		}

		return strBuilder.toString();
	}
}
