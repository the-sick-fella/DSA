class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (target > sum || target < 0 - sum) return 0;

        int[][] dp = new int[nums.length][2 * sum + 1];
        dp[0][sum + nums[0]]++;
        dp[0][sum - nums[0]]++;

        for (int idx = 1; idx < nums.length; idx++) {
            for (int curr = 0 - sum; curr <= sum; curr++) {
                int add = 0, sub = 0;
                if (sum + curr - nums[idx] >= 0)  add = dp[idx - 1][sum + curr - nums[idx]];
                if (curr + nums[idx] <= sum) sub = dp[idx - 1][sum + curr + nums[idx]];
                dp[idx][sum + curr] = add + sub;
            }
        }
        return dp[nums.length - 1][sum + target];
    }
}