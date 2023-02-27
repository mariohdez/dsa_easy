package array;

public class ReplaceElementsSolution {
	public int[] replaceElements(int[] arr) {
		int ptr = arr.length - 1;
		int largestSoFar = arr[ptr];

		arr[ptr] = -1;
		ptr--;

		while (ptr > -1 ) {
			int temp = arr[ptr];

			arr[temp] = largestSoFar;

			if (temp > largestSoFar) {
				largestSoFar = temp;
			}

			--ptr;
		}

		return arr;
	}
}
