class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[] = new int[n];

        dp[n - 1] = grid[m - 1][n - 1] == 1 ? 0 : 1;

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (grid[r][c] == 1) {
                    dp[c] = 0;
                    continue;
                }

                int right = 0;
                if (c < n - 1 && grid[r][c + 1] != 1)
                    dp[c] += dp[c + 1];
            }
        }

        return dp[0];
    }
}