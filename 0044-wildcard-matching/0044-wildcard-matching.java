class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[m][n] = true;
        boolean flag = true;
        for (int j = n - 1; j >= 0; j--) {
            if (p.charAt(j) != '*')
                flag = false;
            dp[m][j] = flag;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else if (p.charAt(j) == '*') {
                    if (dp[i + 1][j] || dp[i][j + 1])
                        dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }

    int f(String s, String p, int i, int j, int[][] dp) {
        // if(i == s.length() && j == p.length()) return 1;
        // if(j == p.length()) return 0;
        if (i == s.length()) {
            for (int idx = j; idx < p.length(); idx++) {
                if (p.charAt(idx) != '*')
                    return 0;
            }
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
            return dp[i][j] = f(s, p, i + 1, j + 1, dp);
        if (p.charAt(j) == '*') {
            if (f(s, p, i + 1, j, dp) == 1 || f(s, p, i, j + 1, dp) == 1)
                return 1;
        }
        return dp[i][j] = 0;
    }
}