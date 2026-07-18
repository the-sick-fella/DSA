class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (target > sum || target < 0 - sum) return 0;

        int[] dp = new int[2 * sum + 1];
        dp[sum + nums[0]]++;
        dp[sum - nums[0]]++;

        for (int idx = 1; idx < nums.length; idx++) {
            int temp[] = new int[2 * sum + 1];
            for (int curr = 0 - sum; curr <= sum; curr++) {
                int add = 0, sub = 0;
                if (sum + curr - nums[idx] >= 0)  add = dp[sum + curr - nums[idx]];
                if (curr + nums[idx] <= sum) sub = dp[sum + curr + nums[idx]];
                temp[sum + curr] = add + sub;
            }
            dp = temp;
        }
        return dp[sum + target];
    }
}