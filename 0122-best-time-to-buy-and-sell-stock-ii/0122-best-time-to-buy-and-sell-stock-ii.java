class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int bought = 0; bought < 2; bought++) {
                if (bought == 1) {
                    int hold = dp[i + 1][1];
                    int sell = nums[i] + dp[i + 1][0];
                    dp[i][bought] = Math.max(hold, sell);
                } else {
                    int buy = -nums[i] + dp[i + 1][1];
                    int skip = dp[i + 1][0];
                    dp[i][bought] = Math.max(buy, skip);
                }
            }
        }
        return dp[0][0];
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