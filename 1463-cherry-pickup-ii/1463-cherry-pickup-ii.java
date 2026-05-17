class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][][] = new int[m][n][n];
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, (int)-1e9);
            }
        }
        dp[0][0][n - 1] = grid[0][0] + grid[0][n - 1];

        for (int r = 1; r < m; r++) {
            for (int c1 = 0; c1 < n; c1++) {
                for (int c2 = 0; c2 < n; c2++) {
                    int res = (int)-1e9;
                    for (int i = -1; i <= 1; i++) {
                        if (c1 + i < 0 || c1 + i >= n)
                            continue;

                        for (int j = -1; j <= 1; j++) {
                            if (c2 + j < 0 || c2 + j >= n)
                                continue;

                            res = Math.max(res, dp[r - 1][c1 + i][c2 + j]);
                        }
                    }

                    res += grid[r][c1];

                    if (c1 == c2) {
                        dp[r][c1][c2] = res;
                        continue;
                    }

                    dp[r][c1][c2] = res + grid[r][c2];
                }
            }
        }

        int ans = 0;
        for (int c1[] : dp[m - 1]) {
            for (int c2 : c1) {
                ans = Math.max(ans, c2);
            }
        }
        return ans;
    }
}