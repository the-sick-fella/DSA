class Solution {
    public int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;

        while (si < ei) {

            int mid = si + (ei - si) / 2;

            if (nums[mid] > nums[ei]) {
                si = mid + 1;
            } else {
                ei = mid;
            }
        }
        int idx = si;

        int ans = bs(nums, 0, idx-1, target);
        if(ans == -1) ans = bs(nums, idx, nums.length-1, target);

        return ans;
    }

    int bs(int [] nums, int si, int ei, int target){
        while(si <= ei){
            int mid = (si + ei)/2;
            if(nums[mid] == target) return mid;

            if(nums[mid] > target) ei = mid - 1;
            else si = mid + 1;
        }

        return -1;
    }
}