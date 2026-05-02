class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] r : board) {
            Arrays.fill(r, '.');
        }

        boolean[] columns = new boolean[n];
        boolean[] ld = new boolean[2*n - 1];
        boolean[] rd = new boolean[2*n - 1];

        solve(n, 0, list, board, columns, ld, rd);
        return list;
    }

    void solve(int n, int row, List<List<String>> list, char[][] board, boolean[] columns, boolean[] ld, boolean[] rd) {
        if (row >= n) {
            List<String> curr = new ArrayList<>();
            for (char[] r : board) {
                curr.add(new String(r));
            }
            list.add(new ArrayList<>(curr));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (columns[c] || ld[row - c + (n-1)] || rd[row + c])
                continue;

            board[row][c] = 'Q';
            columns[c] = true;
            ld[row - c + n - 1] = true;
            rd[row + c] = true;

            solve(n, row + 1, list, board, columns, ld, rd);

            board[row][c] = '.';
            columns[c] = false;
            ld[row - c + n - 1] = false;
            rd[row + c] = false;
        }
    }
}