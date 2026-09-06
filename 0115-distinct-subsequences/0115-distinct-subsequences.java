class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int dp [][] = new int [m][n];
        for(int r[] : dp) Arrays.fill(r, -1);
        StringBuilder sb = new StringBuilder();
        return f(s, t, 0, 0, sb, dp);
    }

    int f(String s, String t, int i, int j, StringBuilder sb, int [][] dp) {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = f(s, t, i+1, j, sb, dp);
        if(s.charAt(i) == t.charAt(j)){
            sb.append(s.charAt(i));
            ans += f(s, t, i+1, j+1, sb, dp);
            sb.deleteCharAt(sb.length()-1);
        }
        return dp[i][j] = ans;
    }
}