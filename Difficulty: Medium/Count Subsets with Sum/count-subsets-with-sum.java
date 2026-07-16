class Solution {
    static int perfectSum(int[] arr, int target) {
        int dp [][] = new int [arr.length][target+1];
        dp[0][0]++;
        if(arr[0] <= target) dp[0][arr[0]]++;
        
        for(int idx = 1; idx < arr.length; idx++){
            for(int sum = 0; sum <= target; sum++){
                int skip = dp[idx-1][sum];
                int pick = 0;
                if(sum >= arr[idx]) pick = dp[idx-1][sum-arr[idx]];
                
                dp[idx][sum] = skip + pick;
            }
        }
        
        return dp[arr.length-1][target];
    }
}