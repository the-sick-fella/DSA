class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int [][] dp = new int[m][n];
        for(int r[]:dp) Arrays.fill(r, -1);
        return f(s, p, 0, 0, dp) == 1 ? true : false;
    }

    int f(String s, String p, int i, int j, int [][] dp){
        if(i == s.length() && j == p.length()) return 1;
        if(j == p.length()) return 0;
        if(i == s.length()){
            for(int idx = j; idx < p.length(); idx++){
                if(p.charAt(idx) != '*') return 0;
            }
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) return dp[i][j] = f(s, p, i+1, j+1, dp);
        if(p.charAt(j) == '*'){
            if(f(s, p, i+1, j, dp) == 1 || f(s, p, i, j+1, dp) == 1) return 1;
        }
        return dp[i][j] = 0;
    }
}