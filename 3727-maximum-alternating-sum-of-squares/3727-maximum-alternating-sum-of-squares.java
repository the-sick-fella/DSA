class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long sum = 0;
        for(int i = 0; i < nums.length/2; i++){
            sum -= (long)nums[i] * nums[i];
        }
        for(int i = nums.length/2; i<nums.length; i++){
            sum += (long)nums[i] * nums[i];
        }
        return sum;
    }
}