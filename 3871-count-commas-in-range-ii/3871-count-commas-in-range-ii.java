class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long val = 999;
        while(val <= n){
            ans += n-val;
            val = val*1000 + 999;
        }
        return ans;
    }
}