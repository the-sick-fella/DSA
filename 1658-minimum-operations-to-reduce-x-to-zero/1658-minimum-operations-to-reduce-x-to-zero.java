class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int num : nums) total += num;
        x = total-x;
        if(x < 0) return -1;
        int i = 0, j = 0, sum = 0, ans = -1;
        while(j < nums.length){
            sum += nums[j++];

            while(sum > x){
                sum -= nums[i++];
            }

            if(sum == x) ans = Math.max(ans, j-i);
        }
        return ans >= 0 ? nums.length - ans : -1;
    }
}