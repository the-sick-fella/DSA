class Solution {
	public int longCommSubstr(String s1, String s2) {
		// code here
		int m = s1.length(), n = s2.length();
		int dp[] = new int [n + 1];
		int max = 0;
		for (int i = 1; i <= m; i++) {
		    int temp [] = new int[n+1];
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) temp[j] = dp[j - 1] + 1;
					
				max = Math.max(temp[j], max);
			}
			dp = temp;
		}
		
		return max;
	}
}
