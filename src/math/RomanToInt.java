package math;

import java.util.Map;
import java.util.HashMap;
import static java.util.Map.entry;

public class RomanToInt {

	private Map<String, Integer> symbolToValueMap = new HashMap<String, Integer>(Map.ofEntries(
			entry("I",  Integer.valueOf(1)),
			entry("V",  Integer.valueOf(5)),
			entry("X",  Integer.valueOf(10)),
			entry("L",  Integer.valueOf(50)),
			entry("C",  Integer.valueOf(100)),
			entry("D",  Integer.valueOf(500)),
			entry("M",  Integer.valueOf(1000)),
			entry("IV", Integer.valueOf(4)),
			entry("IX", Integer.valueOf(9)),
			entry("XL", Integer.valueOf(40)),
			entry("XC", Integer.valueOf(90)),
			entry("CD", Integer.valueOf(400)),
			entry("CM", Integer.valueOf(900))
	));

	public int romanToInt(String s) {
		int value = 0;
		int i = 0;

		while (i < s.length()) {
			if (isTwoLetteredSymbol(s, i, s.length())) {
				value += (this.symbolToValueMap.get(s.substring(i, i + 2))).intValue();
				i += 2;
			} else {
				value += this.symbolToValueMap.get(s.substring(i, i + 1)).intValue();
				i += 1;
			}
		}

		return value;
	}
	
	public int romanToIntBackwards(String s) {
		int lastIndex = s.length() - 1;
		int lastValue = this.symbolToValueMap.get(s.substring(lastIndex, lastIndex + 1));
		int value = lastValue;

		for (int currentIndex = s.length() - 2; currentIndex >= 0; --currentIndex) {
			int currentValue = this.symbolToValueMap.get(s.substring(currentIndex, currentIndex + 1));
			if (currentValue < lastValue) {
				value -= currentValue;
			} else {
				value += currentValue;
			}

			lastValue = currentValue;
		}


		return value;
	}

	public boolean isTwoLetteredSymbol(String s, int index, int maxLength) {
		if (!(index + 1 < maxLength)) {
			return false;
		}

		String possibleSymbol = s.substring(index, index + 2);

		return this.symbolToValueMap.containsKey(possibleSymbol);
	}
}
