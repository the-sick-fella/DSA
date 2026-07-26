class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length-1;
        int ans1 = nums[n] * nums[n-1] * nums[n-2];

        int ans2 = nums[0]* nums[1] * nums[n];
        return Math.max(ans1, ans2);
    }
}