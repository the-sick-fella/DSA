class Solution {
    public int fib(int n) {
        if(n < 2) return n;

        int p2 = 0;
        int p1 = 1;

        for(int i = 2; i<=n; i++){
            int curr = p1 + p2;
            p2 = p1;
            p1 = curr;
        }

        return p1;
    }
}