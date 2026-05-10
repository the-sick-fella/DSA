class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp, -1);
            if (i == 0)
                res = Math.max(res, getMax(nums, 0, dp, nums.length - 1));
            else
                res = Math.max(res, getMax(nums, i, dp, nums.length));
        }

        return res;
    }

    int getMax(int[] nums, int idx, int[] dp, int n) {
        if (idx >= n)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int pick = nums[idx] + getMax(nums, idx + 2, dp, n);
        int skip = getMax(nums, idx + 1, dp, n);

        return dp[idx] = Math.max(pick, skip);
    }
}