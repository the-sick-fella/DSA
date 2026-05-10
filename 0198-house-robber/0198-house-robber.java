class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int p2 = nums[0];
        int p1 = Math.max(nums[1], nums[0]);

        for(int i = 2; i<nums.length; i++){
            int pick = p2 + nums[i];
            int skip = p1;

            int curr = Math.max(pick, skip);

            p2 = p1;
            p1 = curr;
        }

        return p1;
    }
}