class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int [n+1][2];
        for(int r[]:dp) Arrays.fill(r, -1);
        return f(prices, 0, 0, dp);
    }
        
    int f(int [] nums, int i, int b, int [][] dp){
        if (i >= nums.length) return 0;
        if(dp[i][b] != -1) return dp[i][b];

        if(b == 1){
            int sell = nums[i] + f(nums, i+2, 0, dp);
            int hold = f(nums, i+1, 1, dp);
            return dp[i][b] = Math.max(sell, hold);
        } else{
            int buy = -nums[i] + f(nums, i+1, 1, dp);
            int skip = f(nums, i+1, 0, dp);
            return dp[i][b] = Math.max(buy, skip);
        }
    }
}