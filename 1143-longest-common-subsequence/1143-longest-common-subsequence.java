class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int dp[] = new int[n+1];

        for (int i = m - 1; i >= 0; i--) {
            int curr [] = new int[n+1];
            for (int j = n - 1; j >= 0; j--) {
                int pick = 0;
                int temp = s2.substring(j, s2.length()).indexOf(s1.charAt(i));
                if (temp != -1) {
                    pick = 1 + dp[temp + j + 1];
                }

                int skip = dp[j];

                curr[j] = Math.max(skip, pick);
            }
            dp = curr;
        }

        return dp[0];
    }
}