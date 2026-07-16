class Solution {
    static int perfectSum(int[] arr, int target) {
        int dp [][] = new int [arr.length][target+1];
        for(int r[] : dp) Arrays.fill(r, -1);
        
        return f(arr, 0, target, 0, dp);
    }
    
    static int f(int [] nums, int idx, int target, int sum, int dp [][]){
        if(sum > target) return 0;
        
        if(idx == nums.length){
            if(sum == target) return 1;
            return 0;
        }
        
        if(dp[idx][sum] != -1) return dp[idx][sum];
        
        int pick = f(nums, idx+1, target, sum+nums[idx], dp);
        int skip = f(nums, idx+1, target, sum, dp);
        
        return dp[idx][sum] = pick + skip;
    }
}