class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][][] dp = new int[n+1][2][3];
        for(int mat [][] : dp){
            for(int r[]: mat) Arrays.fill(r, -1);
        }
        return f(prices, 0, 0, 0, dp);
    }

    int f(int [] nums, int i, int bought, int count, int [][][] dp){
        if(i == nums.length) return 0;

        if(dp[i][bought][count] != -1) return dp[i][bought][count];

        if(bought == 1){
            int sell = nums[i] + f(nums, i+1, 0, count, dp);
            int hold = f(nums, i+1, 1, count, dp);
            return dp[i][bought][count] = Math.max(sell, hold);
        } else{
            if(count == 2) return 0;
            int buy = -nums[i] + f(nums, i+1, 1, count+1, dp);
            int skip = f(nums, i+1, 0, count, dp);
            return dp[i][bought][count] = Math.max(buy, skip);
        }
    }
}