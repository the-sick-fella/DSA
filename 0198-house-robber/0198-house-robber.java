class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(nums, dp, 0);
    }

    int f(int [] nums, int [] dp, int idx){
        if(idx >= nums.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int take = nums[idx] + f(nums, dp, idx+2);
        int skip = f(nums, dp, idx+1);

        return dp[idx] = Math.max(take, skip);
    }
}