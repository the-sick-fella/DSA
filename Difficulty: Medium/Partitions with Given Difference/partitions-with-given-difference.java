class Solution {
	public int countPartitions(int[] arr, int diff) {
		// code here
		int sum = 0;
		for (int num : arr) sum += num;
		
		int target = sum - diff;
		if (target < 0 || target%2 != 0) return 0;
		target /= 2;
		
		int dp [] = new int[target + 1];

		dp[0]++;
		if (arr[0] <= target) dp[arr[0]]++;
		
		for (int idx = 1; idx<arr.length; idx++) {
		    int [] temp = new int[target+1];
			for (int curr = 0; curr <= target; curr++) {
				int skip = dp[curr];
				int pick = 0;
				if (arr[idx] <= curr) pick = dp[curr - arr[idx]];
				
				temp[curr] = skip + pick;
			}
			dp = temp;
		}
		
		return dp[target];
	}
}
