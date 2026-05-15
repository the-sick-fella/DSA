class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[] = new int[n+1];

        for (int i = 0; i < triangle.get(n - 1).size(); i++)
            dp[i] = triangle.get(n - 1).get(i);

        for (int i = n - 2; i >= 0; i--) {
            int temp [] = new int[i+1];
            for (int j = triangle.get(i).size()-1; j >= 0; j--) {
                int left = dp[j];
                int right = dp[j + 1];

                temp[j] = Math.min(left, right) + triangle.get(i).get(j);
            }
            dp = temp;
        }

        return dp[0];
    }
}