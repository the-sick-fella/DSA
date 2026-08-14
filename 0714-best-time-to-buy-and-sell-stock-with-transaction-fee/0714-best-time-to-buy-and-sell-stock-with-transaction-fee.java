class Solution {
    public int maxProfit(int[] nums, int fee) {
        int n = nums.length;
        int dp[] = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            int temp [] = new int[2];
            for (int b = 1; b >= 0; b--) {
                if (b == 1) {
                    int sell = nums[i] - fee + dp[0];
                    int hold = dp[1];
                    temp[b] = Math.max(sell, hold);
                } else {
                    int buy = -nums[i] + dp[1];
                    int skip = dp[0];
                    temp[b] = Math.max(buy, skip);
                }
            }
            dp = temp;
        }
        return dp[0];
    }
}