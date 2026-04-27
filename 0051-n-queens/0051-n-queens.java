class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        boolean[][] matrix = new boolean[n][n];
        queens(matrix, 0, list);
        return list;
    }

    void queens(boolean[][] nums, int row, List<List<String>> list){
        if(row >= nums.length){
            List<String> temp = new ArrayList<>();
            for(boolean r[] : nums){
                StringBuilder sb = new StringBuilder();
                for(boolean c : r){
                    if(c) sb.append('Q');
                    else sb.append('.');
                }
                temp.add(sb.toString());
            }
            list.add(temp);

            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(!qp(nums, row, i)){
                nums[row][i] = true;
                queens(nums, row+1, list);
                nums[row][i] = false;
            }
        }
    }

    boolean qp(boolean[][] nums, int r, int c) {
        int i = 0;
        for (; i < r; i++) {
            if (nums[i][c])
                return true;
        }

        i = r - 1;
        int j = c - 1;
        while (i >= 0 && j >= 0) {
            if (nums[i][j])
                return true;
            i--;
            j--;
        }

        i = r - 1;
        j = c + 1;
        while (i >= 0 && j < nums.length) {
            if (nums[i][j])
                return true;

            i--;
            j++;
        }

        return false;
    }

}