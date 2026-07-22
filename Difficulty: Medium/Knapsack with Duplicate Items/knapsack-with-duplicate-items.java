class Solution {
	public int knapSack(int val[], int wt[], int capacity) {
		// code here
		int dp [][] = new int[wt.length][capacity + 1];
		for (int sum = 0; sum <= capacity; sum++) {
				dp[0][sum] = sum/wt[0] * val[0];
		}
		
		for (int idx = 1; idx < wt.length; idx++) {
			for (int sum = 0; sum <= capacity; sum++) {
				int skip = dp[idx - 1][sum];
				int pick = 0;
				if (sum >= wt[idx])
					pick = dp[idx][sum - wt[idx]] + val[idx];
				
				dp[idx][sum] = Math.max(skip, pick);
			}
		}
		return dp[wt.length - 1][capacity];
	}
}
