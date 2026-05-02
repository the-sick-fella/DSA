class Solution {
    public void solveSudoku(char[][] board) {
        boolean x = solve(0, 0, board);
    }

    boolean solve(int row, int col, char[][] board) {
        if (row == 9) {
            return true;
        }

        boolean solved;

        if (board[row][col] != '.') {
            if (col == 8)
                solved = solve(row + 1, 0, board);
            else
                solved = solve(row, col + 1, board);

            if (solved)
                return true;
            return false;
        }

        for (char i = '1'; i <= '9'; i++) {
            if (valid(row, col, i, board)) {
                board[row][col] = i;

                if (col == 8)
                    solved = solve(row + 1, 0, board);
                else
                    solved = solve(row, col + 1, board);

                if (solved)
                    return true;

                board[row][col] = '.';
            }
        }

        return false;
    }

    boolean valid(int row, int col, char n, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == n || board[row][i] == n)
                return false;
        }

        int r = 3 * (row / 3);
        int c = 3 * (col / 3);
        for (int i = 0; i < 9; i++) {
            if (r == row && c == col) {
                c++;
                continue;
            }

            if (i > 0 && i % 3 == 0) {
                r++;
                c = 3 * (col / 3);
            }

            if (board[r][c] == n)
                return false;
            c++;
        }

        return true;
    }
}