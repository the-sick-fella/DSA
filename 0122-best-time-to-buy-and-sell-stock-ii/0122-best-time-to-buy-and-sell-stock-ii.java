class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int r[] : dp)
            Arrays.fill(r, -1);
        return f(prices, 0, 0, dp);
    }

    int f(int[] nums, int i, int bought, int[][] dp) {
        if (i == nums.length)
            return 0;

        if (dp[i][bought] != -1)
            return dp[i][bought];

        if (bought == 1) {
            int hold = f(nums, i + 1, 1, dp);
            int sell = nums[i] + f(nums, i + 1, 0, dp);
            return dp[i][bought] = Math.max(hold, sell);
        }
        
        int buy = -nums[i] + f(nums, i + 1, 1, dp);
        int skip = f(nums, i + 1, 0, dp);
        return dp[i][bought] = Math.max(buy, skip);
    }
}