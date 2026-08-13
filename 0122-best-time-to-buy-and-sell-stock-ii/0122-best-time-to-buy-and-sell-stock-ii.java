class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n+1][2];
        for(int r[]: dp)Arrays.fill(r, -1);
        return f(prices, 0, 0, dp);
    }

    int f(int []nums, int i, int bought, int [][]dp){
        if(i==nums.length)return 0;
        if(dp[i][bought] != -1)return dp[i][bought];

        int profit = 0;
        if(bought == 1){
            int sell = nums[i] + f(nums, i+1, 0, dp);
            int hold = f(nums, i+1, 1, dp);
            profit = Math.max(sell, hold);
        }else{
            int buy = -nums[i] + f(nums, i+1, 1, dp);
            int skip = f(nums, i+1, 0, dp);
            profit = Math.max(buy, skip);
        }
        return dp[i][bought] = profit;
    }
}