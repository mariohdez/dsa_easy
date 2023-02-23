package array;

public class CanPlaceFlowersSolution {

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int numSpots = flowerbed.length;
		int goodSpots = 0;

		for (int i = 0; i < flowerbed.length; ++i) {
			if (flowerbed[i] == 1)
				continue;

			boolean emptyToTheLeft = i == 0 || i - 1 > -1 && flowerbed[i - 1] == 0;
			boolean emptyToTheRight = i == numSpots - 1 || i + 1 < numSpots && flowerbed[i + 1] == 0;

			if (emptyToTheLeft && emptyToTheRight) {
				flowerbed[i] = 1;
				goodSpots++;
			}
		}

		return goodSpots >= n ? true : false;
	}
}
