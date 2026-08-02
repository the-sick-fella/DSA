class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[] dp = new int[s2.length()];

        boolean found = false;
        for (int j = 0; j < s2.length(); j++) {
            if (s1.charAt(0) == s2.charAt(j)) found = true;
            if (found) dp[j]++;
        }

        for (int i = 1; i < s1.length(); i++) {
            int temp[] = new int[s2.length()];
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    temp[j]++;
                    if (j > 0) temp[j] += dp[j - 1];
                    continue;
                }

                int first = dp[j];
                int sec = 0;
                if (j > 0) sec = temp[j - 1];

                temp[j] = Math.max(first, sec);
            }
            dp = temp;
        }
        return dp[s2.length() - 1];
    }
}