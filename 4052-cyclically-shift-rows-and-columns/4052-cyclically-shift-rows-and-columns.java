class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rs, int[] cs) {
        for (int r = 0; r < n; r++) {
            int s = rs[r];
            shift(grid, r, s);
        }

        for (int c = 0; c < n; c++) {
            int s = cs[c];
            shift2(grid, c, s);
        }

        return grid;
    }

    void shift(int[][] grid, int r, int s) {
        int n = grid.length;
        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = grid[r][s % n];
            s++;
        }

        for (int j = 0; j < n; j++) {
            grid[r][j] = temp[j];
        }
    }

    void shift2(int[][] grid, int c, int s) {
        int n = grid.length;
        int temp[] = new int[n];
        for (int r = 0; r < n; r++) {
            temp[r] = grid[s % n][c];
            s++;
        }

        for (int r = 0; r < n; r++) {
            grid[r][c] = temp[r];
        }
    }
}