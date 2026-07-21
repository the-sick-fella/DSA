class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int [] dp = new int [amount+1];
        for(int sum = 0; sum<=amount; sum++){
            if(sum%coins[0] == 0) dp[sum] = 1;
        }

        for(int idx = 1; idx<n; idx++){
            for(int sum = 0; sum<=amount; sum++){
                int skip = dp[sum];
                int pick = 0;
                if(sum >= coins[idx]) pick = dp[sum - coins[idx]];
                dp[sum] = skip + pick;
            }
        }
        return dp[amount];
    }
}