class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int curr [] = new int [n];
        curr[0] = nums[0];
        int idx = 0;

        for(int i = 1; i<n; i++){
            if(nums[i] > curr[idx]) curr[++idx] = nums[i];
            else {
                int c = ceiling (curr, idx, nums[i]);
                curr[c] = nums[i];
            }
        }
        return idx+1;
    }

    int ceiling(int [] temp, int ei, int target){
        int si = 0;
        while(si <= ei){
            int mid = (si + ei)/2;
            if(temp[mid] == target) return mid;
            if(temp[mid] > target) ei = mid - 1;
            else si = mid + 1;
        }
        return si;
    }
}