class Solution {
    static int perfectSum(int[] arr, int target) {
        int dp [] = new int [target+1];
        dp[0]++;
        if(arr[0] <= target) dp[arr[0]]++;
        
        for(int idx = 1; idx < arr.length; idx++){
            int temp [] = new int [target+1];
            for(int sum = 0; sum <= target; sum++){
                int skip = dp[sum];
                int pick = 0;
                if(sum >= arr[idx]) pick = dp[sum-arr[idx]];
                
                temp[sum] = skip + pick;
            }
            dp = temp;
        }
        
        return dp[target];
    }
}