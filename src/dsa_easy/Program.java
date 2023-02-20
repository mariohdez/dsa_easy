package dsa_easy;

import array.MinimumIndexSumOfTwoStrings;

public class Program {
	public static void main(String[] args) {
		MinimumIndexSumOfTwoStrings mists = new MinimumIndexSumOfTwoStrings();

		String[] list1 = new String[] {"happy","sad","good"};
		String[] list2 = new String[] {"sad","happy","good"};
		String[] res = mists.findRestaurant(list1, list2);


		return;
	}
}
