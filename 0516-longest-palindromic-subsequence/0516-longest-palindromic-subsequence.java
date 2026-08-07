class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int [][] dp = new int [n][n];
        for(int r[]: dp) Arrays.fill(r, -1);
        return f(s, dp, 0, n-1);
    }

    int f(String s,int [][]dp, int i, int j){
        if(i>j) return 0;
        if(i==j) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = 2 + f(s, dp, i+1, j-1);
        return dp[i][j] = Math.max(f(s, dp, i+1, j), f(s, dp, i, j-1));
    }
}