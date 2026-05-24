class Solution {
    public int minOperations(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        boolean x = true;
        for(int i = 0; i<n; i++){
            int next = nums[(i+1)%n];

            if(next != (nums[i] + 1)%n){
                x = false;
                break;
            }
        }
        if(x){
            int idx1 = -1;
            for(int j = 0; j<n; j++){
                if(nums[j] == 0){
                    idx1 = j;
                    break;
                }
            }

            ans = Math.min(ans, Math.min(idx1, 2+(n-idx1)%n));
        }
        boolean y = true;
        for(int i = 0; i<n; i++){
            int next = nums[(i+1)%n];
            if(next != (nums[i]-1+n)%n){
                y = false;
                break;
            }
        }
        if(y){
            int idx = -1;
            for(int j = 0; j<n; j++){
                if(nums[j] == n-1){
                    idx = j;
                    break;
                }
            }
            ans = Math.min(ans, Math.min(1+(n-idx)%n,1+idx));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}