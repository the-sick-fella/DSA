class Solution {
    public int rob(int[] nums) {
        int prevPick = nums[0];
        int prevSkip = 0;

        for (int i = 1; i < nums.length; i++) {
            int skip = Math.max(prevSkip, prevPick);
            int pick = prevSkip + nums[i];

            prevPick = pick;
            prevSkip = skip;
        }
        return Math.max(prevPick, prevSkip);
    }
}