package dsa_easy;

import array.NumberOfUniqueEmailsSolution;

public class Program {
	public static void main(String[] args) {
		NumberOfUniqueEmailsSolution noues = new NumberOfUniqueEmailsSolution();
		String[] emails = new String[] {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
		int cnt = noues.numUniqueEmails(emails);

		System.out.println("count: " + cnt);

		return;
	}
}
