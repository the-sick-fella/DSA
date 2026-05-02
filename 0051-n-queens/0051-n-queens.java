class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char [][] board = new char[n][n];
        for(char[] r : board){
            Arrays.fill(r, '.');
        }
        
        solve(n, 0, list, board);
        return list;
    }

    void solve(int n, int row, List<List<String>> list, char[][] board){
        if(row >= n){
            List<String> curr = new ArrayList<>();
            for(char [] r : board){
                curr.add(new String(r));
            }
            list.add(new ArrayList<>(curr));
            return;
        }


        for(int c = 0; c<n; c++){
            if(valid(n, row, c, board)){
                board[row][c] = 'Q';
                
                solve(n, row+1, list, board);

                board[row][c] = '.';
            }
        }
    }

    boolean valid(int n, int row, int col, char [][] board){
        //row
        int r = 0;
        for(; r<row; r++){
            if(board[r][col] == 'Q') return false;
        }

        //left diagonal
        r = row-1;
        int c = col - 1;
        while(r>=0 && c>=0){
            if(board[r][c] == 'Q') return false;
            r--;
            c--;
        }

        //right diagonal
        r = row-1;
        c = col + 1;
        while(r>=0 && c<n){
            if(board[r][c] == 'Q') return false;
            r--;
            c++;
        }

        return true;
    }
}