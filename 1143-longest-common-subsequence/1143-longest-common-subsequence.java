class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    continue;
                }

                int first = dp[i - 1][j];
                int sec = dp[i][j - 1];

                dp[i][j] = Math.max(first, sec);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]) i--;
            else j--;
        }
        System.out.println(sb.reverse().toString());

        return sb.length();
    }
}