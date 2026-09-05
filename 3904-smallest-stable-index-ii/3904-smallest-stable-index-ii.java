class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int [] maxA = new int[nums.length];
        int [] minA = new int[nums.length];

        int maxNum = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            maxA[i] = Math.max(maxNum, nums[i]);
            maxNum = Math.max(maxNum, nums[i]);
        }

        int minNum = Integer.MAX_VALUE;
        for(int i = nums.length-1; i>=0; i--){
            minA[i] = Math.min(minNum, nums[i]);
            minNum = Math.min(minNum, nums[i]);
        }

        
        for(int i = 0; i<nums.length; i++){
            if(maxA[i] - minA[i] <= k) return i;
        }

        return -1;
    }
}