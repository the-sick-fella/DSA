class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int dp[][] = new int[m][n];
        for (int r[] : dp)
            Arrays.fill(r, -1);

        return f(s1, m, s2, n, 0, 0, dp);
    }

    int f(String s1, int m, String s2, int n, int i1, int i2, int [][] dp){
        if(i1 >= m || i2 >= n) return 0;
        if(dp[i1][i2] != -1) return dp[i1][i2];

        int pick = 0;
        int temp = s2.substring(i2, s2.length()).indexOf(s1.charAt(i1));
        if(temp != -1){
            pick = 1 + f(s1, m, s2, n, i1+1, temp+i2+1, dp);
        } 

        int skip = f(s1, m, s2, n, i1+1, i2, dp);

        return dp[i1][i2] = Math.max(skip, pick);
    }
}