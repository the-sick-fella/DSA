class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int temp1[] = new int[nums.length - 1];
        int temp2[] = new int[nums.length - 1];

        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1)
                temp1[i] = nums[i];
            if (i > 0)
                temp2[i - 1] = nums[i];
        }

        return Math.max(getMax(temp1), getMax(temp2));
    }

    int getMax(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int p2 = nums[0];
        int p1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int pick = nums[i] + p2;
            int skip = p1;

            int curr = Math.max(pick, skip);
            p2 = p1;
            p1 = curr;
        }

        return p1;
    }
}