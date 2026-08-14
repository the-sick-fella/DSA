class Solution {
    public int maxProfit(int k, int[] nums) {
        int n = nums.length;
        int[] dp = new int[2 * k + 1];
        int[] temp = new int[2 * k + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int t = 2 * k - 1; t >= 0; t--) {
                if (t % 2 == 1) {
                    int sell = nums[i] + dp[t + 1];
                    int hold = dp[t];
                    temp[t] = Math.max(sell, hold);
                } else {
                    int buy = -nums[i] + dp[t + 1];
                    int skip = dp[t];
                    temp[t] = Math.max(buy, skip);
                }
            }
            dp = temp;
        }
        return dp[0];
    }
}