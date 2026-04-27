class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0, new boolean[1]);
    }

    void solve(char[][] board, int r, int c, boolean[] found){
        if(r == 9){
            found[0] = true;
            return;
        }

        if(board[r][c] != '.'){
            if(c<8) solve(board, r, c+1, found);
            else solve(board, r+1, 0, found);
            return;
        }

        for(char i = '1'; i <='9'; i++){
            if(valid(board, r, c, i)){
                board[r][c] = i;

                if(c < 8) solve(board, r, c+1, found);
                else solve(board, r+1, 0, found);

                if(found[0]) return;
                board[r][c] = '.';
            }
        }
    }

    boolean valid(char[][] board, int r, int c, char val){
        int i = 0;
        for(; i<9; i++){
            if(board[i][c] == val || board[r][i] == val) return false;
        }
        
        i = r - r%3;
        int j = c - c%3;

        for(int x = 0; x<3; x++){
            j = c - c%3;
            for(int y = 0; y<3; y++){
                if(i == r && j == c) continue;
                if(board[i][j] == val) return false;
                j++;
            }
            i++;
        }

        return true;
    }
}