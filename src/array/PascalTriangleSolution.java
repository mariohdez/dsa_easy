package array;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PascalTriangleSolution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

		if (numRows == 1) {
			triangle.add(new ArrayList<Integer>(Arrays.asList(1)));
			return triangle;
		}

		if (numRows == 2) {
			triangle.add(new ArrayList<Integer>(Arrays.asList(1)));
			triangle.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
			return triangle;
		}

		for (int row = 3; row <= numRows; ++row) {
			List<Integer> newRow = new ArrayList<Integer>();
			newRow.add(1);

			for (int i = 1; i < row - 1; ++i) {
				newRow.add(triangle.get(row - 2).get(i - 1) + triangle.get(row - 2).get(i));
			}
			newRow.add(1);
			triangle.add(newRow);
		}

		return triangle;
	}
}
