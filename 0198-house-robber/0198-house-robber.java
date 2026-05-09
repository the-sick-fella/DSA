class Solution {
    public int rob(int[] nums) {
        int dp [] = new int[nums.length];
        dp[0] = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            int one = dp[i-1];
            int two;
            if(i == 1) two = nums[i];
            else two = dp[i-2] + nums[i];

            dp[i] = Math.max(one, two);
        }

        return dp[nums.length-1];
    }
}