package array;

public class MaxAreaSolution {
	public int maxArea(int[] heights) {
		int maxArea = 0;
		int left = 0;
		int right = heights.length - 1;

		while (left < right) {
			int width = right - left;
			maxArea = Math.max(maxArea, width * Math.min(heights[left], heights[right]));
			if (heights[left] <= heights[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}
}
