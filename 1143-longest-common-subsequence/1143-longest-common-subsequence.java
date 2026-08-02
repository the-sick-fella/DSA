class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];

        boolean found = false;
        for (int j = 0; j < s2.length(); j++) {
            if (s1.charAt(0) == s2.charAt(j)) found = true;
            if(found) dp[0][j]++;
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j]++;
                    if (j > 0)
                        dp[i][j] += dp[i - 1][j - 1];
                    continue;
                }

                int first = dp[i - 1][j];
                int sec = 0;
                if (j > 0) sec = dp[i][j - 1];

                dp[i][j] = Math.max(first, sec);
            }
        }
        return dp[s1.length() - 1][s2.length() - 1];
    }
}