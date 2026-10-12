class Solution {
    public List<Integer> maxPrimeSubset(int n, int s) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> primes = getPrimes(n);
        int m = primes.size();
        int [][] dp = new int[m+1][s+1];
        for(int [] r: dp) Arrays.fill(r, 1_000_000);
        dp[m][0] = 0;

        for(int i = m-1; i>=0; i--){
            int p = primes.get(i);
            for(int t = 0; t<=s; t++){
                dp[i][t] = dp[i+1][t];
                if(t >=p && dp[i+1][t-p] + 1 < dp[i][t])
                dp[i][t] = dp[i+1][t-p] + 1;
            }
        }

        int best = 0;
        for(int t = s; t>=1; t--){
            if(dp[0][t] < 1_000_000){
                best = t;
                break;
            }
        }

        if(best == 0) return ans;

        int t = best;
        for(int i = 0; i<m && t > 0; i++){
            int p = primes.get(i);
            if( t >= p && dp[i+1][t-p] + 1 == dp[i][t]){
                ans.add(p);
                t -= p;
            }
        }
        
        return ans;
    }

    List<Integer> getPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        if (n == 1)
            return list;
        boolean temp[] = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!temp[i]) {
                list.add(i);
                for (long j = (long) i * i; j <= n; j += i)
                    temp[(int) j] = true;
            }
        }
        return list;

    }
}