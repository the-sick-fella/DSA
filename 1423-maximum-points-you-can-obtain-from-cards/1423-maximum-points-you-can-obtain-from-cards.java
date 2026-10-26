class Solution {
    public int maxScore(int[] nums, int k) {
        int total = 0, curr = 0, n = nums.length;
        int i = 0, j = 0;
        while (j < n - k) {
            curr += nums[j];
            total += nums[j++];
        }
        int sum = curr;
        while (j < n) {
            curr -= nums[i++];
            curr += nums[j];
            sum = Math.min(sum, curr);
            total += nums[j++];
        }
        return total - sum;
    }
}