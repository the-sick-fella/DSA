class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> map = new HashMap<>();
        long sum = 0, ans = Long.MIN_VALUE;
        for(int num : nums){
            sum += num;
            if(map.containsKey(num + k)){
                ans = Math.max(ans, sum-map.get(num+k));
            }
            if(map.containsKey(num - k)){
                ans = Math.max(ans, sum-map.get(num-k));
            }

            long temp = sum - num;
            map.put(num, Math.min(map.getOrDefault(num, Long.MAX_VALUE), temp));
        }
        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}