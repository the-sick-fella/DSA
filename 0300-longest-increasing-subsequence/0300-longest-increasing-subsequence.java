class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int prev = n - 1; prev >= 0; prev--) {
                int skip = dp[i + 1][prev];
                int take = 0;
                if (prev == 0 || nums[i - 1] > nums[prev - 1])
                    take = 1 + dp[i + 1][i];

                dp[i][prev] = Math.max(skip, take);
            }
        }
        return f(nums, 1, 0, dp);
    }

    int f(int[] nums, int i, int prev, int[][] dp) {
        if (i == nums.length + 1)
            return 0;

        if (dp[i][prev] != -1)
            return dp[i][prev];

        int skip = f(nums, i + 1, prev, dp);
        int take = 0;
        if (prev == 0 || nums[i - 1] > nums[prev - 1])
            take = 1 + f(nums, i + 1, i, dp);

        return dp[i][prev] = Math.max(skip, take);
    }
}