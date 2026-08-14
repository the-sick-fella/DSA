class Solution {
    public int maxProfit(int k, int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2 * k + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int t = 2 * k - 1; t >= 0; t--) {
                if (t % 2 == 1) {
                    int sell = nums[i] + dp[i + 1][t + 1];
                    int hold = dp[i + 1][t];
                    dp[i][t] = Math.max(sell, hold);
                } else {
                    int buy = -nums[i] + dp[i + 1][t + 1];
                    int skip = dp[i + 1][t];
                    dp[i][t] = Math.max(buy, skip);
                }
            }
        }
        return dp[0][0];
    }
}