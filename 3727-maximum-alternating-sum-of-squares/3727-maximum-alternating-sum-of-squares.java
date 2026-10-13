class Solution {
    public long maxAlternatingSum(int[] nums) {
        long temp[] = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = (long) nums[i]*nums[i];
        }
        Arrays.sort(temp);
        long sum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum -= temp[i];
        }
        for (int i = nums.length / 2; i < nums.length; i++) {
            sum += temp[i];
        }
        return sum;
    }
}