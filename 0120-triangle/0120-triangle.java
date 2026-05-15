class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp [][] = new int[n][];
        for(int i = 0; i<triangle.size(); i++){
            dp[i] = new int[triangle.get(i).size()];
            Arrays.fill(dp[i], 10000000);
        }
        
        return f(triangle, 0, 0, dp);
    }

    int f(List<List<Integer>> list, int listNo, int idx, int [][] dp){
        if(listNo >= list.size()) return 0;

        if(dp[listNo][idx] != 10000000) return dp[listNo][idx];

        int left = f(list, listNo + 1, idx, dp);
        int right = f(list, listNo + 1, idx+1, dp);

        return dp[listNo][idx] = Math.min(left, right) + list.get(listNo).get(idx);
    }
}