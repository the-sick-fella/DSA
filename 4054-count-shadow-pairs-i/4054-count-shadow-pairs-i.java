class Solution {
    public long shadowPairs(int[] nums) {
        int n = nums.length;
        int [] val = new int[n];
        long count[] = new long[n];
        long[] sum = new long[n];
        int top = -1;
        long ans = 0;

        for(int i = 0; i<=n; i++){
            boolean f= (i==n);
            while(top >= 0 && (f || val[top] > nums[i])){
                long c = count[top];
                long s = sum[top];
                ans += (c*i - s - c) - (c*(c-1)/2);
                top--;
            }

            if(f) break;

            if(top >= 0 && val[top] == nums[i]){
                count[top]++;
                sum[top] += i;
            } else{
                top++;
                val[top]=nums[i];
                count[top]=1;
                sum[top]=i;
            }
        }
        return ans;
    }
}