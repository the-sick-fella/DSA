class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n+1];
        dp[n]=1;
        for(int i = m-1; i>=0; i--){
            int temp [] = new int[n+1];
            temp[n]=1;
            for(int j = n-1; j>=0; j--){
                temp[j] = dp[j];
                if(s.charAt(i) == t.charAt(j)) temp[j] += dp[j+1];
            }
            dp = temp;
        }
        return dp[0];
    }
}