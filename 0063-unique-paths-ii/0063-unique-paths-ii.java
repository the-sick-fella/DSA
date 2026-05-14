class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp [][] = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1] == 0 ? 1 : 0;

        for(int r = m-1; r>=0; r--){
            for(int c = n-1; c>=0; c--){
                if(r == m-1 && c == n-1) continue;

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