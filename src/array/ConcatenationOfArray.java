package array;

public class ConcatenationOfArray {
	public int[] getConcatenation(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n * 2];

		for (int ptr = 0; ptr < n*2; ++ptr) {
			ans[ptr] = nums[ptr % n];
		}

		return ans;
	}
}
