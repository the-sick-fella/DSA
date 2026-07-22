class Solution {
	public int knapSack(int val[], int wt[], int capacity) {
		// code here
		int dp [] = new int[capacity + 1];
		for (int sum = 0; sum <= capacity; sum++) {
				dp[sum] = sum/wt[0] * val[0];
		}
		
		for (int idx = 1; idx < wt.length; idx++) {
		    int [] temp = new int[capacity+1];
			for (int sum = 0; sum <= capacity; sum++) {
				int skip = dp[sum];
				int pick = 0;
				if (sum >= wt[idx])
					pick = temp[sum - wt[idx]] + val[idx];
				
				temp[sum] = Math.max(skip, pick);
			}
			dp = temp;
		}
		return dp[capacity];
	}
}
