class Solution {
    public int minDistance(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        for (int j = 0; j < n; j++) dp[j] = n - j;
        for (int i = m - 1; i >= 0; i--) {
            int temp[] = new int[n+1];
            temp[n] = m-i;
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) temp[j] = dp[j + 1];
                else {
                    int rep = 1 + dp[j + 1];
                    int del = 1 + dp[j];
                    int ins = 1 + temp[j + 1];
                    temp[j] = Math.min(rep, Math.min(del, ins));
                }
            }
            dp = temp;
        }
        return dp[0];
    }
}