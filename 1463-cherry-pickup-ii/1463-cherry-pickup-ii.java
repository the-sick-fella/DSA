class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp [][][] = new int [m][n][n];
        for(int r[][] : dp){
            for(int r2[] : r) Arrays.fill(r2, -1);
        }
        return f(grid, m, n, 0, 0, n-1, dp);
    }

    int f(int [][]grid, int m, int n, int r, int c1, int c2, int dp[][][]){
        if(r<0 || r >= m || c1<0 || c2<0 || c1 >= n || c2 >=n) return 0;

        if(dp[r][c1][c2] != -1) return dp[r][c1][c2];

        int max = 0;
        for(int i = -1; i<2; i++){
            for(int j = -1; j<2; j++){
                max = Math.max(max, f(grid, m, n, r+1, c1+i, c2+j,dp));
            }
        }

        if(c1 == c2) return dp[r][c1][c2] = max + grid[r][c1];
        return dp[r][c1][c2] = max + grid[r][c1] + grid[r][c2];
    }
}