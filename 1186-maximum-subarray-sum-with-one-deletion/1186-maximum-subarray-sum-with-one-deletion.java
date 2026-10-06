class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0];
        int ans = arr[0];
        int sum = 0, lsum = 0, rsum = 0;

        int l [] = new int[n];
        for(int i = 0; i<n; i++){
            l[i] = lsum;
            sum += arr[i];
            lsum += arr[i];
            ans = Math.max(ans, sum);
            if(sum < 0) sum = 0;
            if(lsum < 0) lsum = 0;
        }

        for(int i = n-1; i>=0; i--){
            int curr = l[i]+rsum;
            if(curr > 0) ans = Math.max(ans, curr);
            rsum += arr[i];
            if(rsum < 0) rsum = 0;
        }
        return ans;
    }
}