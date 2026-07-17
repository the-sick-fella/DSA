class Solution {
	public int countPartitions(int[] arr, int diff) {
		// code here
		int sum = 0;
		for (int num : arr) sum += num;
		
		int target = sum - diff;
		if (target < 0 || target%2 != 0) return 0;
		target /= 2;
		
		int dp [][] = new int[arr.length][target + 1];

		dp[0][0]++;
		if (arr[0] <= target) dp[0][arr[0]]++;
		
		for (int idx = 1; idx<arr.length; idx++) {
			for (int curr = 0; curr <= target; curr++) {
				int skip = dp[idx - 1][curr];
				int pick = 0;
				if (arr[idx] <= curr) pick = dp[idx - 1][curr - arr[idx]];
				
				dp[idx][curr] = skip + pick;
			}
		}
		
		return dp[arr.length-1][target];
	}
}
