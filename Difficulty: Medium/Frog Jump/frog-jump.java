class Solution {
    int minCost(int[] h) {
        if(h.length < 2) return 0;
        // code here
        int p2 = 0;
        int p1 = Math.abs(h[0] - h[1]);

        for(int i = 2; i<h.length; i++){
            int one = Math.abs(h[i] - h[i-1]) + p1;
            int two = Math.abs(h[i] - h[i-2]) + p2;

            int curr = Math.min(one, two);
            p2 = p1;
            p1 = curr;
        }
        return p1;
    }
}