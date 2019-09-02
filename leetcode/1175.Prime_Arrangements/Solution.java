class Solution {
    public int numPrimeArrangements(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        int sqrt = (int)Math.sqrt(n);
        int prime = 2;
        primes[0] = false;
        primes[1] = false;
        int i = 2;
        while (prime <= sqrt) {
            for (i = prime * 2; i <= n; i += prime) {
                primes[i] = false;
            }

            for (i = prime + 1; i <= sqrt; i ++) {
                if (primes[i]) break;
            }
            prime = i;
        }

        int prime_count = 0;
        for (i = 2; i <= n; i ++) {
            if (primes[i]) { prime_count ++; }
        }

        long prime_permu_count = 1;
        int mod = 1000000007;
        for (i = 1; i <= prime_count; i ++) {
            prime_permu_count = (prime_permu_count * i) % mod;
        }

        long not_prime_permu_count = 1;
        for (i = 1; i <= (n - prime_count); i ++) {
            not_prime_permu_count = (not_prime_permu_count * i) % mod;
        }

        long ret = (prime_permu_count * not_prime_permu_count) % mod;
        return (int)ret;

    }
}
