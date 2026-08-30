class Solution {
    public int minimumDeletions(int[] nums) {
        int min[] = new int[2], max[] = new int[2];
        min[0] = Integer.MAX_VALUE;
        max[0] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max[0] < nums[i]) {
                max[0] = nums[i];
                max[1] = i;
            }

            if (nums[i] < min[0]) {
                min[0] = nums[i];
                min[1] = i;
            }
        }

        int single = Math.min(min[1] + 1, nums.length - min[1]);
        if (min[0] == max[0])
            return single;

        single += Math.min(max[1] + 1, nums.length - max[1]);

        int common = nums.length - Math.min(min[1], max[1]);
        common = Math.min(common, Math.max(min[1], max[1]) + 1);
        
        return Math.min(common, single);
    }
}