class Solution {
    public boolean checkDivisibility(int n) {
        int x = n, sum = 0, p = 1;
        while(x > 0){
            int rem = x%10;
            sum += rem;
            p *= rem;
            x/=10;
        }

        return n%(sum+p) == 0 ? true : false;
    }
}