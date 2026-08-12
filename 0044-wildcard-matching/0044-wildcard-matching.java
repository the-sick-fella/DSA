class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int j = n - 1; j >= 0; j--) {
            if (p.charAt(j) != '*')
                break;
            dp[j] = true;
        }

        for (int i = m - 1; i >= 0; i--) {
            boolean temp[] = new boolean[n + 1];
            for (int j = n - 1; j >= 0; j--) {
                if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
                    temp[j] = dp[j + 1];
                else if (p.charAt(j) == '*') {
                    if (dp[j] || temp[j + 1])
                        temp[j] = true;
                }
            }
            dp = temp;
        }
        return dp[0];
    }
}