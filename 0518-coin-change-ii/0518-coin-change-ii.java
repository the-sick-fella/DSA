class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int sum = 0; sum <= amount; sum++) {
            if (sum % coins[0] == 0)
                dp[0][sum] = 1;
        }

        for (int idx = 1; idx < n; idx++) {
            for (int sum = 0; sum <= amount; sum++) {
                int skip = dp[idx - 1][sum];
                int pick = 0;
                if (sum >= coins[idx])
                    pick = dp[idx][sum - coins[idx]];
                dp[idx][sum] = skip + pick;
            }
        }
        return dp[n - 1][amount];
    }
}