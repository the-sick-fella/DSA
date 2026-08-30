class Solution {
    public int sumDecoded(long[] nums) {
        long MOD = (long)1e9 + 7;
        long sum = 0;
        for(long num : nums){
            int w = (int)(num % 10);
            long d = num / 10;
            String s = String.valueOf(d);
            long x = Long.parseLong(s.substring(0, w));
            long y = Long.parseLong(s.substring(w, s.length()));

            x%=MOD;
            long temp = 1;
            while(y>0){
                if(y%2==1){
                temp = (temp*x) % MOD;
                }
                x = (x*x)%MOD;
                y/=2;
            }
            sum = (sum + temp)%MOD;
        }
        return (int)sum;
    }
}