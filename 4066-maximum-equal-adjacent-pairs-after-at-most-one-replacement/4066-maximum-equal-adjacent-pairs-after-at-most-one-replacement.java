class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
     int base = 0, best = 0;
        Map<Long, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length-1; i++){
            int a = nums[i];
            int b = nums[i+1];

            if(a == b) base++;
            else{
                int x = Math.min(a,b);
                int y = Math.max(a,b);
                long key = ((long) x << 32) | (y & 0xffffffffL);
                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);
                best = Math.max(best, count);
            }
        }
        return base + best;
    }
}