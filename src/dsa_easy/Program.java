package dsa_easy;

import array.IsomorphicStringsSolution;

public class Program {
	public static void main(String[] args) {
		IsomorphicStringsSolution iss = new IsomorphicStringsSolution();

		/*
		 * 
		 * 
"badc"
"baba"
		 * 
		 * */
		boolean res = iss.isIsomorphic("badc", "baba");

		System.out.println("isIsomorphic: " + res);

		return;
	}
}
