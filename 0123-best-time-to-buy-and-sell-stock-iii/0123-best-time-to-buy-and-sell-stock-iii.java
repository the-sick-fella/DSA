class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][3];

        for (int i = n - 1; i >= 0; i--) {
            int temp[][] = new int[2][3];
            for (int bought = 1; bought >= 0; bought--) {
                for (int count = 2; count >= 0; count--) {
                    if (bought == 1) {
                        int sell = nums[i] + dp[0][count];
                        int hold = dp[1][count];
                        temp[bought][count] = Math.max(sell, hold);
                    } else {
                        if (count == 2)
                            temp[bought][count] = 0;
                        else {
                            int buy = -nums[i] + dp[1][count + 1];
                            int skip = dp[0][count];
                            temp[bought][count] = Math.max(buy, skip);
                        }
                    }
                }
            }
            dp = temp;
        }
        return dp[0][0];
    }
}