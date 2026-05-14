class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        dp[m-1][n-1] = 1;

        for(int r = m-1; r>=0; r--){
            for(int c = n-1; c>=0; c--){
                if(r == m-1 && c == n-1) continue;

                int down = 0;
                if(r <m -1) down = dp[r+1][c];
                
                int right = 0;
                if(c < n-1) right = dp[r][c+1];

                dp[r][c] = down + right;
            }
        }

        return dp[0][0];
    }
}