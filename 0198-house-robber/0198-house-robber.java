class Solution {
    public int rob(int[] nums) {
        int res = 0;
        int dp [] = new int[nums.length];
        Arrays.fill(dp, -1);
        
        for(int i = 0; i<nums.length; i++){
            res = Math.max(res, getMax(nums, i, dp));
        }

        return res;
    }

    int getMax(int [] nums, int idx, int dp[]){
        if(idx >= nums.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int val = 0;
        for(int i = idx + 2; i<nums.length; i++){
            int curr = getMax(nums, i, dp);
            val = Math.max(val, curr);
        }

        return dp[idx] = val + nums[idx];
    }
}