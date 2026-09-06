class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int dp [][] = new int [m][n];
        for(int r[] : dp) Arrays.fill(r, -1);
        return f(s, t, 0, 0, dp);
    }

    int f(String s, String t, int i, int j, int [][] dp) {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = f(s, t, i+1, j, dp);
        if(s.charAt(i) == t.charAt(j)) ans += f(s, t, i+1, j+1, dp);
        return dp[i][j] = ans;
    }
}