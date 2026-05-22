class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        int si = 0;
        int ei = n;
        int idx = -1;

        while(si<ei){
            int mid = (si+ei)/2;
            if(nums[mid] > nums[mid+1]){
                idx = mid;
                break;
            }

            if(nums[mid] > nums[ei]) si = mid+1;
            else ei = mid;
        }

        int ans = bs(nums, 0, idx, target);
        if(ans == -1) ans = bs(nums, idx+1, n, target);

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