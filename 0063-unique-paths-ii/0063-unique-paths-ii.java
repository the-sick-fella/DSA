class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp [] = new int[n];

        int prev = 0;
        for(int c = n-1; c>=0; c--){
            if(c < n-1 && dp[c+1] == 0) prev = 1;
            if(prev != 1 && grid[m-1][c] != 1){
                dp[c] = 1;
            }
        }

        for(int r = m-2; r>=0; r--){
            int curr[] = new int[n];
            for(int c = n-1; c>=0; c--){
                if(grid[r][c] == 1){
                    curr[c] = 0;
                    continue;
                }

                int down = 0;
                if(r < m-1 && grid[r+1][c] != 1) down = dp[c];

                int right = 0;
                if(c < n-1 && grid[r][c+1] != 1) right = curr[c+1];

                curr[c] = right + down;
            }

            dp = curr;
        }

        return dp[0];
    }
}