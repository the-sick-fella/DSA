class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int num : nums) sum += num;
        if(sum%2 != 0) return false;

        int target = sum/2;
        boolean [] dp = new boolean[target+1];

        dp[0] = true;
        if(nums[0] <= target) dp[nums[0]] = true;
        
        for(int i = 1; i<n; i++){
            boolean temp [] = new boolean[target+1];
            for(int curr = 0; curr<=target; curr++){
                if(dp[curr] || (curr - nums[i] >= 0 && dp[curr-nums[i]])) temp[curr] = true;
            }
            dp = temp;
        }

        return dp[target];
    }
}