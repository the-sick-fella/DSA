class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        for(int [] row : dp) Arrays.fill(row, -1);
        return recursion(m, n, 0, 0, dp);
    }

    int recursion(int m, int n, int r, int c, int [][] dp){
        if(r >= m || c >= n) return 0;
        
        if(r == m-1 && c == n-1) return 1;

        if(dp[r][c] != -1) return dp[r][c];

        int down = recursion(m, n, r+1, c, dp);
        int right = recursion(m, n, r, c+1, dp);

        return dp[r][c] = right + down;
    }
}