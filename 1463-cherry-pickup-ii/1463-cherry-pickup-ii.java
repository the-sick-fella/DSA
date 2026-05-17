class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return f(grid, m, n, 0, 0, n - 1);
    }

    int f(int[][] grid, int m, int n, int r, int c1, int c2) {
        if (r >= m || c1 < 0 || c1 >= n || c2 < 0 || c2 >= n)
            return 0;

        int res = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                res = Math.max(res, f(grid, m, n, r + 1, c1 + i, c2 + j));
            }
        }

        res += grid[r][c1];

        if (c1 == c2)
            return res;
        return res += grid[r][c2];
    }
}