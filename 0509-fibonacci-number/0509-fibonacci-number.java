class Solution {
    public int fib(int n) {
        Integer dp [] = new Integer[n+1];
        return f(n, dp);
    }

    int f(int n, Integer [] dp){
        if(n<2) return n;

        if(dp[n] != null) return dp[n];

        return dp[n] = f(n-1, dp) + f(n-2, dp);
    }
}