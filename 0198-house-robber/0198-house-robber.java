class Solution {
    public int rob(int[] nums) {
        int [] pick = new int [nums.length];
        int skip [] = new int[nums.length];
        skip[0] = 0;
        pick[0] = nums[0];

        for(int i = 1; i<nums.length; i++){
            skip[i] = Math.max(skip[i-1], pick[i-1]);
            pick[i] = skip[i-1]+nums[i];
        }
        return Math.max(pick[nums.length-1], skip[nums.length-1]);
    }
}