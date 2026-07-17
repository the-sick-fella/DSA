class Solution {
	public int countPartitions(int[] arr, int diff) {
		// code here
		int sum = 0;
		for (int num : arr) sum += num;
		
		int target = sum - diff;
		if (target < 0 || target%2 != 0) return 0;
		target /= 2;
		
		int dp [][] = new int[arr.length][target + 1];
		for (int r[] : dp) Arrays.fill(r, -1);
		
		return f(arr, 0, 0, target, dp);
	}
	
	static int f(int [] nums, int idx, int curr, int target, int [][] dp) {
		if (curr > target) return 0;
		if (idx == nums.length) {
			if (curr == target) return 1;
			return 0;
		}
		
		if (dp[idx][curr] != -1) return dp[idx][curr];
		
		int pick = f(nums, idx + 1, curr + nums[idx], target, dp);
		int skip = f(nums, idx + 1, curr, target, dp);
		
		return dp[idx][curr] = skip + pick;
	}
}
