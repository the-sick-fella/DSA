class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int num : nums) sum += num;
        if(sum%2 != 0) return false;

        int target = sum/2;
        boolean [][] dp = new boolean[n][target+1];

        dp[0][0] = true;
        if(nums[0] <= target) dp[0][nums[0]] = true;
        
        for(int i = 1; i<n; i++){
            for(int curr = target; curr>=0; curr--){
                if((curr >= nums[i] && dp[i-1][curr-nums[i]]) || dp[i-1][curr]) dp[i][curr] = true;
            }
        }

        return dp[n-1][target];
    }
}