class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[] = new int[n + 1];

        for (int i = m - 1; i >= 0; i--) {
            int temp[] = new int[n+1];
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j))
                    temp[j] = 1 + dp[j + 1];
                else
                    temp[j] = Math.max(temp[j + 1], dp[j]);
            }
            dp = temp;
        }

        return m + n - 2 * dp[0];
    }
}