class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int [][] dp = new int [n+1][2*k+1];
        for(int r[]:dp) Arrays.fill(r, -1);
        return f(prices, k, 0, 0, dp);
    }

    int f(int [] nums, int k, int i, int t, int [][]dp){
        if(i == nums.length || t == 2*k) return 0;

        if(dp[i][t] != -1) return dp[i][t];

        if(t%2 == 1){
            int sell = nums[i] + f(nums, k, i+1, t+1, dp);
            int hold = f(nums, k, i+1, t, dp);
            return dp[i][t] = Math.max(sell, hold);
        } else{
            int buy = -nums[i] + f(nums, k, i+1, t+1, dp);
            int skip = f(nums, k, i+1, t, dp);
            return dp[i][t] = Math.max(buy, skip);
        }
    }
}