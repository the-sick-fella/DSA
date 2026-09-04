class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int [] minA = new int[nums.length];

        int minNum = Integer.MAX_VALUE;
        for(int i = nums.length-1; i>=0; i--){
            minA[i] = Math.min(minNum, nums[i]);
            minNum = Math.min(minNum, nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            if(Math.max(max, nums[i]) - minA[i] <= k) return i;
        }

        return -1;
    }
}