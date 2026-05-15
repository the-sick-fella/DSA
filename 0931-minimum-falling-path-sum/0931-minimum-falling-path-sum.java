class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];
        int res = 100000;
        for (int[] row : dp)
            Arrays.fill(row, 100000);

        for (int i = 0; i < n; i++) {
            res = Math.min(res, f(matrix, n, 0, i, dp));
        }

        return res;
    }

    int f(int[][] grid, int n, int r, int c, int[][] dp) {
        if (r < 0 || r >= n || c < 0 || c >= n)
            return 100000;

        if (dp[r][c] != 100000)
            return dp[r][c];

        int ans = 100000;
        ans = Math.min(ans, f(grid, n, r + 1, c - 1, dp));
        ans = Math.min(ans, f(grid, n, r + 1, c, dp));
        ans = Math.min(ans, f(grid, n, r + 1, c + 1, dp));

        if (ans == 100000)
            return dp[r][c] = grid[r][c];
        return dp[r][c] = ans + grid[r][c];
    }
}