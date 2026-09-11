class Solution {
    public int totalNumbers(int[] digits) {
        int f [] = new int[10];
        for(int digit : digits) f[digit]++;
        int ans = 0;
        for(int num = 100; num<999; num+=2){
            int temp [] = new int[10];
            int n = num;
            while(n>0){
                int digit = n%10;
                temp[digit]++;
                if(temp[digit] > f[digit]) break;
                n/=10;
            }

            if(n==0) ans++;
        }
        return ans;
    }
}