package array;

public class CountAndSaySolution {
	public String countAndSay(int n) {
		String currentString = "1";

		for (int i = 2; i <= n; ++i) {
			String nextString = say(currentString);
			currentString = nextString;
		}

		return currentString;
	}

	public String say(String number) {
		String numberSaid = "";
		int k = 0;

		for (int i = 0; i < number.length(); i = k) {	
			while (k < number.length() && number.charAt(i) == number.charAt(k)) {
				k++;
			}

			numberSaid += String.valueOf(k - i) + String.valueOf(number.charAt(i));
		}

		return numberSaid;
	}
	
	/*
	 *
    public String countAndSay(int n) {
        String currentString = "1";
        for (int i = 2; i <= n; i++) {
            String nextString = "";
            for (int j = 0, k = 0; j < currentString.length(); j = k) {
                while (k < currentString.length() && currentString.charAt(k) == currentString.charAt(j)) k++;
                nextString += Integer.toString(k - j) + currentString.charAt(j);
            }
            currentString = nextString;
        }
        return currentString;
    }
	 *
	 * */
}
