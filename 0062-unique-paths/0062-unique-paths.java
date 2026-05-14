class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        Arrays.fill(dp[m-1], 1);

        for(int r = m-2; r >= 0; r--){
            for(int c = n-1; c>=0; c--){
                int down = dp[r+1][c];
                
                int right = 0;
                if(c < n-1) right = dp[r][c+1];

                dp[r][c] = down + right;
            }
        }

        return dp[0][0];
    }
}