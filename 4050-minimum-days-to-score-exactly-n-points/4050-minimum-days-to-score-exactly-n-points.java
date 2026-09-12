class Solution {
    public int minDays(int n) {
        int x = 1;
        while((x*x+1)/2 <= n) x++;
        int dp[][] = new int[n][x+2];
        for (int r[] : dp)
            Arrays.fill(r, -1);
        return 1 + f(n - 1, 2, dp);
    }

    int f(int n, int s, int[][] dp) {
        if(n==0) return 0;
        if (n == s) return 1;
        if (dp[n][s] != -1)
            return dp[n][s];

        int take = Integer.MAX_VALUE, skip = Integer.MAX_VALUE;
        if (n > s)
            take = f(n - s, s + 1, dp);
        if (s > 1)
            skip = f(n, 1, dp);
        return dp[n][s] = 1 + Math.min(take, skip);
    }
}