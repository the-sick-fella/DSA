class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int [] left = new int[n];
        int right [] = new int[n];
        int max = 0;
        for(int i = 1; i<n; i++){
            max = Math.max(max, nums[i-1]);
            left[i] = max;
        }
        max = 0;
        for(int i = n-2; i>=0; i--){
            max = Math.max(max, nums[i+1]);
            right[i] = max;
        }
        int ans = 0;
        for(int i = 0; i<nums.length; i++){
            int curr = Math.min(left[i], right[i]) - nums[i];
            if(curr > 0) ans += curr; 
        }
        return ans;
    }
}