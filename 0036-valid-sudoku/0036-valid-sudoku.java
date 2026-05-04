class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                char c = board[i][j];
                if(c != '.' && !valid(board, i, j, c)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean valid(char[][] board, int row, int col, char val){
        board[row][col] = '.';
        for(int i = 0; i<9; i++){
            if(board[row][i] == val || board[i][col] == val) return false;
        }

        int r = 3*(row/3); 
        int c = 3*(col/3);

        for(int i = 0; i<9; i++){
            if(board[r + i/3][c + i%3] == val) return false;
        }

        board[row][col] = val;

        return true;
    }
}