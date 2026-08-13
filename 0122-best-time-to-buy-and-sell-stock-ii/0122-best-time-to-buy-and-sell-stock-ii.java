class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int[] dp = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            int temp [] = new int[2];
            for (int bought = 0; bought < 2; bought++) {
                int profit = 0;
                if (bought == 1) {
                    int sell = nums[i] + dp[0];
                    int hold = dp[1];
                    profit = Math.max(sell, hold);
                } else {
                    int buy = -nums[i] + dp[1];
                    int skip = dp[0];
                    profit = Math.max(buy, skip);
                }
                temp[bought] = profit;
            }
            dp = temp;
        }
        return dp[0];
    }

    int f(int[] nums, int i, int bought, int[][] dp) {
        if (i == nums.length)
            return 0;
        if (dp[i][bought] != -1)
            return dp[i][bought];

        int profit = 0;
        if (bought == 1) {
            int sell = nums[i] + f(nums, i + 1, 0, dp);
            int hold = f(nums, i + 1, 1, dp);
            profit = Math.max(sell, hold);
        } else {
            int buy = -nums[i] + f(nums, i + 1, 1, dp);
            int skip = f(nums, i + 1, 0, dp);
            profit = Math.max(buy, skip);
        }
        return dp[i][bought] = profit;
    }
}