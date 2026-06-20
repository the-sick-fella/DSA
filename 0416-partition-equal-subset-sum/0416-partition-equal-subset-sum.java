class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) sum += num;

        if(sum%2 != 0) return false;

        int [][] dp = new int[n][sum+1];
        for(int r[] : dp) Arrays.fill(r, -1);

        return f(nums, n, 0, 0, sum, dp) == 1 ? true : false;
    }

    int f(int [] nums, int n, int idx, int curr, int sum, int [][] dp){
        if(curr == sum/2) return 1;
        if(idx >= n || curr > sum/2) return 0;

        if(dp[idx][curr] != -1) return dp[idx][curr];

        if(f(nums, n, idx+1, curr+nums[idx], sum, dp) == 1 || f(nums, n, idx+1, curr, sum, dp) == 1) return dp[idx][curr] = 1;
        return dp[idx][curr] = 0;
    }
}