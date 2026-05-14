class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int dp [][] = new int[grid.length][grid[0].length];
        for(int row[] : dp) Arrays.fill(row, -1);
        return recursion(grid, 0, 0, dp);
    }

    int recursion(int [][] grid, int r, int c, int dp[][]){
        if(grid[r][c] == 1) return 0;
        if(r == grid.length-1 && c == grid[0].length-1) return 1;   

        if(dp[r][c] != -1) return dp[r][c];     

        int down = 0;
        if(r < grid.length-1 && grid[r+1][c] != 1) down = recursion(grid, r+1, c, dp);

        int right = 0;
        if(c < grid[0].length-1 && grid[r][c+1] != 1) right = recursion(grid, r, c+1, dp);

        return dp[r][c] = right + down;
    }
}