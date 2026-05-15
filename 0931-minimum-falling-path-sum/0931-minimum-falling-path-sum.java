class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = matrix[n - 1][i];

        for (int i = n - 2; i >= 0; i--) {
            int [] curr = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                curr[j] = dp[j];

                if (j > 0)
                    curr[j] = Math.min(curr[j], dp[j - 1]);
                if (j < n - 1)
                    curr[j] = Math.min(curr[j], dp[j + 1]);

                curr[j] += matrix[i][j];
            }

            dp = curr;
        }

        int res = 100000;
        for (int num : dp)
            res = Math.min(res, num);

        return res;
    }
}