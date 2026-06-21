class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        long [] pre = new long[n+1];
        for(int i = 0; i<n; i++){
            pre[i+1] = pre[i]+nums[i];
        }

        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                long sum = pre[j+1] - pre[i];

                if(valid(sum, x)) count++;
            }
        }

        return count;
    }

    boolean valid(long n, int x) {
        if(n%10 != x) return false;

        while(n >= 10){
            n/=10;
        }
        return n == x;
    }
}