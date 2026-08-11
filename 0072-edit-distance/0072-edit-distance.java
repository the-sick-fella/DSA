class Solution {
    public int minDistance(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int r[] : dp)
            Arrays.fill(r, -1);
        return f(s, t, 0, 0, dp);
    }

    int f(String s, String t, int i, int j, int[][] dp) {
        int m = s.length(), n = t.length();
        if (i == m)
            return n - j;
        if (j == n)
            return m - i;

        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == t.charAt(j))
            return f(s, t, i + 1, j + 1, dp);

        int rep = 1 + f(s, t, i + 1, j + 1, dp);
        int del = 1 + f(s, t, i + 1, j, dp);
        int ins = 1 + f(s, t, i, j + 1, dp);
        return dp[i][j] = Math.min(rep, Math.min(del, ins));
    }
}