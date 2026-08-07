class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int temp [] = new int[n+1];
            for (int j = i + 1; j <= n; j++) {
                if (i == j - 1) temp[j] = 1;
                else if (s.charAt(i) == s.charAt(j - 1)) temp[j] = 2 + dp[j - 1];
                else temp[j] = Math.max(dp[j], temp[j - 1]);
            }
            dp = temp;
        }
        return dp[n];
    }
}