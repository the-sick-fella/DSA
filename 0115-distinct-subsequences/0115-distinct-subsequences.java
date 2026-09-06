class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int dp[][] = new int[m+1][n+1];
        for(int r[] : dp) r[n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int ans = dp[i + 1][j];
                if (s.charAt(i) == t.charAt(j))
                    ans += dp[i + 1][j + 1];
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }

    int f(String s, String t, int i, int j, int[][] dp) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = f(s, t, i + 1, j, dp);
        if (s.charAt(i) == t.charAt(j))
            ans += f(s, t, i + 1, j + 1, dp);
        return dp[i][j] = ans;
    }
}