class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        for(int i = 0; i<nums.length; i++) ans+=f(nums, target, i, 1, 0);
        return ans;
    }

    int f(int [] nums, int target, int idx, int size, int count){
        if(idx >= nums.length) return 0;
        if(nums[idx] == target) count++;
        int res = f(nums, target, idx+1, size+1, count);
        if(count > size/2) return 1 + res;
        return res;
    }
}