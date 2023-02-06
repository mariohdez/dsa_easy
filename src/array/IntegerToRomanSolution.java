package array;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class IntegerToRomanSolution {
	private List<DivisorSymbolPair> divisorSymbolPairList = new ArrayList<DivisorSymbolPair>(Arrays.asList(
			new DivisorSymbolPair(1000, "M"),
			new DivisorSymbolPair(900, "CM"),
			new DivisorSymbolPair(500, "D"),
			new DivisorSymbolPair(400, "CD"),
			new DivisorSymbolPair(100, "C"),
			new DivisorSymbolPair(90, "XC"),
			new DivisorSymbolPair(50, "L"),
			new DivisorSymbolPair(40, "XL"),
			new DivisorSymbolPair(10, "X"),
			new DivisorSymbolPair(9, "IX"),
			new DivisorSymbolPair(5, "V"),
			new DivisorSymbolPair(4, "IV"),
			new DivisorSymbolPair(1, "I")
			));

	public String intToRoman(int num) {
		StringBuilder strBuilder = new StringBuilder();

		for (int i = 0; i < divisorSymbolPairList.size(); ++i) {
			DivisorSymbolPair dsp = divisorSymbolPairList.get(i);

			int divisor = dsp.getDivisor();

			int numberOfSymbols = num / divisor;

			if (numberOfSymbols > 0) {
				num = num % divisor;

				for (int k = 0; k < numberOfSymbols; ++k) {
					strBuilder.append(dsp.getSymbol());
				}
			}
		}

		return strBuilder.toString();
	}

	public class DivisorSymbolPair {
		private int divisor;
		private String symbol;

		public DivisorSymbolPair(int d, String s) {
			this.divisor = d;
			this.symbol = s;
		}

		public int getDivisor() { return this.divisor; }

		public String getSymbol() { return this.symbol; }
	}
}
