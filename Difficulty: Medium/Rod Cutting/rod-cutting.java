class Solution {
	public int cutRod(int[] price) {
		// code here
		int n = price.length;
		int [] dp = new int[n + 1];
		for (int idx = 0; idx<n; idx++) {
			for (int sum = 0; sum <= n; sum++) {
				int skip = 0;
				if (idx>0) skip = dp[sum];
				
				int pick = 0;
				if (sum - idx - 1 >= 0) pick = dp[sum - idx - 1] + price[idx];
				
				dp[sum] = Math.max(skip, pick);
			}
		}
		
		return dp[n];
	}
}
