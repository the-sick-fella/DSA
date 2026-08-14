class Solution {
    public int maxProfit(int[] nums, int fee) {
        int n = nums.length;
        int dp[][] = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int b = 1; b >= 0; b--) {
                if (b == 1) {
                    int sell = nums[i] - fee + dp[i + 1][0];
                    int hold = dp[i + 1][1];
                    dp[i][b] = Math.max(sell, hold);
                } else {
                    int buy = -nums[i] + dp[i + 1][1];
                    int skip = dp[i + 1][0];
                    dp[i][b] = Math.max(buy, skip);
                }
            }
        }
        return dp[0][0];
    }

    int f(int[] nums, int fee, int i, int b, int[][] dp) {
        if (i == nums.length)
            return 0;
        if (dp[i][b] != -1)
            return dp[i][b];

        if (b == 1) {
            int sell = nums[i] - fee + f(nums, fee, i + 1, 0, dp);
            int hold = f(nums, fee, i + 1, 1, dp);
            return dp[i][b] = Math.max(sell, hold);
        } else {
            int buy = -nums[i] + f(nums, fee, i + 1, 1, dp);
            int skip = f(nums, fee, i + 1, 0, dp);
            return dp[i][b] = Math.max(buy, skip);
        }
    }
}