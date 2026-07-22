class Solution {
	public int knapSack(int val[], int wt[], int capacity) {
		// code here
		int dp [] = new int[capacity + 1];
		dp[0] = 0;
		for (int idx = 0; idx < wt.length; idx++) {
			for (int sum = 0; sum <= capacity; sum++) {
				int skip = 0;
				if(idx > 0) skip = dp[sum];
				int pick = 0;
				if (sum >= wt[idx])
					pick = dp[sum - wt[idx]] + val[idx];
				
				dp[sum] = Math.max(skip, pick);
			}
		}
		return dp[capacity];
	}
}
