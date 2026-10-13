class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> ans = new ArrayList<>();
        if(n == 1) return ans;
        List<Integer> primes = getPrimes(n);
        long sum = 0;
        for(int prime : primes){
            sum += prime;
            if(sum > s) break;
            ans.add(prime);
        }
        return ans;
    }

    // Sieve of Eratosthenes
    List<Integer> getPrimes(int n){
        List<Integer> primes = new ArrayList<>();
        boolean temp [] = new boolean[n+1];
        for(int i = 2; i<=n; i++){
            if(!temp[i]){
                primes.add(i);

                for(long j = (long)i*i; j<=n; j+=i) temp[(int)j] = true;
            }
        }
        return primes;
    }
}