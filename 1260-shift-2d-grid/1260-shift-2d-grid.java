class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> list = new ArrayList<>();
        for (int r[] : grid) {
            for (int num : r)
                list.add(num);
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        k%=(m*n);
        for (int i = 0; i < list.size(); i++) {
            if (i - k >= 0)
                curr.add(list.get(i - k));
            else
                curr.add(list.get(i - k + list.size()));

            if(curr.size() == n){
                ans.add(List.copyOf(curr));
                curr = new ArrayList<>();
            }
        }

        return ans;
    }
}