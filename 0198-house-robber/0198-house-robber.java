class Solution {
    public int rob(int[] nums) {
        int p2 = 0;
        int p1 = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            int curr = Math.max(p2 + nums[i], p1);

            p2 = p1;
            p1 = curr;
        }

        return p1;
    }
}