class Solution {
    public int countCommas(int n) {
        int ans = 0;

        while(n>999){
            ans+=(n-999);
            n/=1000;
        }

        return ans;
    }
}