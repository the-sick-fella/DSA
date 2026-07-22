class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int dp [][] = new int[wt.length][capacity+1];
        // for(int sum = 0; sum<=capacity; sum++){
        //     if(sum%wt[0] == 0) dp[0][sum] = sum/wt[0] * val[0];
        // }
        dp[0][0] = 0;
        
        // for(int num : dp[0]) System.out.println(num);
        
        for(int idx = 0; idx < wt.length; idx++){
            for(int sum = 0; sum <= capacity; sum++){
                int skip = 0;
                if(idx > 0) skip = dp[idx-1][sum];
                int pick = 0;
                if(sum >= wt[idx]) pick = dp[idx][sum - wt[idx]] + val[idx];
                
                dp[idx][sum] = Math.max(skip, pick);
            }
        }
        return dp[wt.length-1][capacity];
    }
    
    static int f(int [] val, int [] wt, int cap, int idx, int sum, int [][] dp){
        if(sum >= cap || idx >= wt.length) return 0;
        
        if(dp[idx][sum] != -1) return dp[idx][sum];
        
        int skip = f(val, wt, cap, idx+1, sum, dp);
        int pick = 0;
        if(wt[idx] <= cap-sum) pick = f(val, wt, cap, idx, sum+wt[idx], dp) + val[idx];
        
        return dp[idx][sum] = Math.max(skip, pick);
    }
}