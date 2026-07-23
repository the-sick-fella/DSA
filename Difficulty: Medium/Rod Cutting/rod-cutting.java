class Solution {
	public int cutRod(int[] price) {
		// code here
		int [][] dp = new int[price.length][price.length];
		for (int r[]: dp)
			Arrays.fill(r, -1);
		return f(price, 0, 0, dp);
	}
	
	static int f(int [] nums, int idx, int sum, int [][] dp) {
		if (sum >= nums.length || idx >= nums.length)
			return 0;
		
		if (dp[idx][sum] != -1)
			return dp[idx][sum];
		
		int skip = f(nums, idx + 1, sum, dp);
		
		int pick = 0;
		if (idx + 1 <= nums.length - sum)
			pick = nums[idx] + f(nums, idx, sum + idx + 1, dp);
		
		return dp[idx][sum] = Math.max(skip, pick);
	}
}
