class Solution {
	public int longCommSubstr(String s1, String s2) {
		// code here
		int [][] dp = new int [s1.length()][s2.length()];
		for(int r[]:dp) Arrays.fill(r, -1);
		return f(s1, s2, 0, 0, dp);
	}
	
	static int f(String s1, String s2, int i, int j, int [][] dp) {
		if (i >= s1.length() || j >= s2.length())
			return 0;
		
		if(dp[i][j] != -1) return dp[i][j];
		
		int curr = 0, i2 = i, j2 = j;
		while (i2<s1.length() && j2<s2.length() && s1.charAt(i2) == s2.charAt(j2)) {
			curr++;
			i2++;
			j2++;
		}
		
		int left = f(s1, s2, i+1, j, dp);
		int right = f(s1, s2, i, j+1, dp);
		
		left = Math.max(left, right);
		curr = Math.max(curr, left);
// 		System.out.println(i + " " + j + " " + curr);
		return dp[i][j] = curr;
	}
}
