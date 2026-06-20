class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;

        if(sum%2 != 0) return false;

        int target = sum/2;
        int [][] dp = new int[nums.length][target+1];
        for(int r[] : dp) Arrays.fill(r, -1);

        return f(nums, 0, 0, target, dp) == 1 ? true : false;
    }

    int f(int [] nums, int idx, int curr, int target, int [][] dp){
        if(curr == target) return 1;
        if(idx >= nums.length || curr > target) return 0;

        if(dp[idx][curr] != -1) return dp[idx][curr];

        if(f(nums, idx+1, curr+nums[idx], target, dp) == 1 || f(nums, idx+1, curr, target, dp) == 1) return dp[idx][curr] = 1;
        return dp[idx][curr] = 0;
    }
}