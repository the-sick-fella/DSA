class Solution {
    public int climbStairs(int n) {
        Integer dp [] = new Integer[n];
        return f(n, 0, dp);
    }

    int f(int n, int idx, Integer [] dp){
        if(idx == n) return 1;

        if(dp[idx] != null) return dp[idx];

        int left = 0, right = 0;

        if(idx < n) left = f(n, idx+1, dp);
        if(idx < n-1) right = f(n, idx+2, dp);

        return dp[idx] = left + right;
    }
}