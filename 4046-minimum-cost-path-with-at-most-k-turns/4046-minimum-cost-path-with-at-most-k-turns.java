class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][][] dp = new int[m][n][5][k+1];
        for (int[][][] t : dp) {
            for (int[][] mat : t) {
                for (int[] r : mat)
                    Arrays.fill(r, -1);
            }
        }
        int ans = f(grid, 0, 0, 0, k, dp);
        return ans >= (int) 1e9 ? -1 : ans;
    }

    int f(int[][] grid, int i, int j, int mov, int k, int[][][][] dp) {
        int m = grid.length, n = grid[0].length;
        if (k < 0 || i < 0 || j < 0 || i == m || j == n)
            return (int) 1e9;
        if (i == m - 1 && j == n - 1)
            return grid[m - 1][n - 1];

        if (dp[i][j][mov][k] != -1)
            return dp[i][j][mov][k];

        int d = (int) 1e9, r = (int) 1e9, u = (int) 1e9, l = (int) 1e9;
        if (mov == 0) {
            d = f(grid, i + 1, j, 1, k, dp);
            r = f(grid, i, j + 1, 2, k, dp);
            u = f(grid, i - 1, j, 3, k, dp);
            l = f(grid, i, j - 1, 4, k, dp);
        } else if (mov == 1) {
            d = f(grid, i + 1, j, 1, k, dp);
            r = f(grid, i, j + 1, 2, k - 1, dp);
            u = f(grid, i - 1, j, 3, k - 1, dp);
            l = f(grid, i, j - 1, 4, k - 1, dp);
        } else if (mov == 2) {
            d = f(grid, i + 1, j, 1, k - 1, dp);
            r = f(grid, i, j + 1, 2, k, dp);
            u = f(grid, i - 1, j, 3, k - 1, dp);
            l = f(grid, i, j - 1, 4, k - 1, dp);
        } else if (mov == 3) {
            d = f(grid, i + 1, j, 1, k - 1, dp);
            r = f(grid, i, j + 1, 2, k - 1, dp);
            u = f(grid, i - 1, j, 3, k, dp);
            l = f(grid, i, j - 1, 4, k - 1, dp);
        } else {
            d = f(grid, i + 1, j, 1, k - 1, dp);
            r = f(grid, i, j + 1, 2, k - 1, dp);
            u = f(grid, i - 1, j, 3, k - 1, dp);
            l = f(grid, i, j - 1, 4, k, dp);
        }

        int ans = Math.min(d, Math.min(r, Math.min(u, l)));
        return dp[i][j][mov][k] = ans + grid[i][j];
    }
}