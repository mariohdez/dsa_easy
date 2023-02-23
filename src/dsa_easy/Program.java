package dsa_easy;

import array.CanPlaceFlowersSolution;

public class Program {
	public static void main(String[] args) {
		CanPlaceFlowersSolution cpfs = new CanPlaceFlowersSolution();
		int n = 2;
		int[] list1 = new int[] {1, 0, 0, 0, 1, 0, 0};
		boolean res = cpfs.canPlaceFlowers(list1, n);

		System.out.println("Can place flowers? " + (res ? "YES." : "NO."));

		return;
	}
}
