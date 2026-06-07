class Solution {
    public boolean consecutiveSetBits(int n) {
        int ans = 0;
        int count = 0;
        while(n>0){
            if(n%2 == 1) count++;
            else count = 0;

            if(count >= 2) ans++;
            n>>=1;
        }
        return ans == 1 ? true : false;
    }
}