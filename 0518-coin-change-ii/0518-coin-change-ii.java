class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length; 
        int [] dp = new int [amount+1];
        dp[0] = 1;

        for(int coin : coins){
            for(int sum = 0; sum<=amount; sum++){
                int skip = dp[sum];
                int pick = 0;
                if(sum >= coin) pick = dp[sum - coin];
                dp[sum] = skip + pick;
            }
        }
        return dp[amount];
    }
}