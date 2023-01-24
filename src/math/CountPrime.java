package math;

public class CountPrime {
	public int countPrimes(int n) {
		if (n < 2) {
			return 0;
		}

		boolean[] primes = new boolean[n];

		for (int i = 2; i <= (int)Math.sqrt(n); ++i) {
			if (!primes[i]) {
				for (int k = i * i; k < n; k += i) {
					primes[k] = true;
				}
			}
		}

		int primeCount = 0;

		for (int i = 2; i < n; ++i) {
			if (!primes[i]) {
				primeCount++;
			}
		}

		return primeCount;
	}
}
