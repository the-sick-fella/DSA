class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for (int i = 0; i < triangle.get(n - 1).size(); i++)
            dp[n - 1][i] = triangle.get(n - 1).get(i);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size()-1; j >= 0; j--) {
                int left = dp[i + 1][j];
                int right = dp[i + 1][j + 1];

                dp[i][j] = Math.min(left, right) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }
}