class Solution {
	public int longCommSubstr(String s1, String s2) {
		// code here
		int m = s1.length(), n = s2.length();
		int dp[][] = new int [m + 1][n + 1];
		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
					
				max = Math.max(dp[i][j], max);
			}
		}
		
		return max;
	}
}
