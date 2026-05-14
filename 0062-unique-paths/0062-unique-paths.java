class Solution {
    public int uniquePaths(int m, int n) {
        int [] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int r = m-2; r >= 0; r--){
            int curr [] = new int[n];
            for(int c = n-1; c>=0; c--){            
                int right = 0;
                if(c < n-1) right = curr[c+1];

                curr[c] = dp[c] + right;
            }

            dp = curr;
        }

        return dp[0];
    }
}