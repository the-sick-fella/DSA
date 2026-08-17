class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int temp[] = new int[n + 1];
            for (int prev = i - 1; prev >= -1; prev--) {
                int skip = dp[prev + 1];
                int take = 0;
                if (prev == -1 || nums[i] > nums[prev]) take = 1 + dp[i + 1];

                temp[prev + 1] = Math.max(skip, take);
            }
            dp = temp;
        }
        return dp[-1 + 1];
    }
}