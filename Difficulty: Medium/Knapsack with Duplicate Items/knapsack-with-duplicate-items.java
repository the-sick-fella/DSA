class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int dp [][] = new int[wt.length][capacity+1];
        for(int r[]:dp) Arrays.fill(r, -1);
        return f(val, wt, capacity, 0, 0, dp);
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