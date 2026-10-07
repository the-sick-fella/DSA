class Solution {
    public int climbStairs(int n) {
        int dp [] = new int [n];
        Arrays.fill(dp, -1);
        return f(n, 0, dp);
    }

    int f(int n, int s, int [] dp){
        if(s>n) return 0;
        if(n<2) return 1;
        if(s == n) return 1;

        if(dp[s] != -1) return dp[s];
        int one = f(n, s+1, dp);
        int two = f(n, s+2, dp);
        return dp[s] = one + two;
    }
}