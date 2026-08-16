class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 2];
        for (int i = n; i >= 1; i--) {
            int temp [] = new int [n+2];
            for (int prev = n - 1; prev >= 0; prev--) {
                int skip = dp[prev];
                int take = 0;
                if (prev == 0 || nums[i - 1] > nums[prev - 1])
                    take = 1 + dp[i];

                temp[prev] = Math.max(skip, take);
            }
            dp = temp;
        }
        return dp[0];
    }
}