class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp [][] = new int[m][n];

        int prev = 0;
        for(int c = n-1; c>=0; c--){
            if(c < n-1 && dp[m-1][c+1] == 0) prev = 1;
            if(prev != 1 && grid[m-1][c] != 1){
                dp[m-1][c] = 1;
            }
        }

        for(int r = m-2; r>=0; r--){
            for(int c = n-1; c>=0; c--){
                if(grid[r][c] == 1){
                    dp[r][c] = 0;
                    continue;
                }

                int down = 0;
                if(r < grid.length-1 && grid[r+1][c] != 1) down = dp[r+1][c];

                int right = 0;
                if(c < grid[0].length-1 && grid[r][c+1] != 1) right = dp[r][c+1];

                dp[r][c] = right + down;
            }
        }

        return dp[0][0];
    }
}