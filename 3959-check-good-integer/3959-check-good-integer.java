class Solution {
    public boolean checkGoodInteger(int n) {
        int sum = 0;
        int sSum = 0;
        while(n > 0){

            int rem = n%10;
            sum += n%10;
            sSum += rem*rem;

            n/=10;
        }

        if(sSum - sum >= 50) return true;
        return false;
    }
}