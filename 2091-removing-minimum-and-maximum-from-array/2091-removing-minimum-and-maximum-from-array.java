class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx = -1;
        int maxIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }

            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }

        int one = Math.min((minIdx+1 + n-maxIdx), (maxIdx+1 + n-minIdx));
        int two = Math.min(1 + Math.max(minIdx, maxIdx), n-Math.min(minIdx, maxIdx));
        return Math.min(one, two);
    }
}