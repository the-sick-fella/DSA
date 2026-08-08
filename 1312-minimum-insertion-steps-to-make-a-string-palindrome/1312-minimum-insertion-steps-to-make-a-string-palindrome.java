class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int temp[] = new int[n+1];
            for (int j = i + 1; j <= n; j++) {
                if (s.charAt(i) == s.charAt(j-1))
                    temp[j] = dp[j - 1];
                else
                    temp[j] = 1 + Math.min(dp[j], temp[j - 1]);
            }
            dp = temp;
        }
        return dp[n];
    }
}