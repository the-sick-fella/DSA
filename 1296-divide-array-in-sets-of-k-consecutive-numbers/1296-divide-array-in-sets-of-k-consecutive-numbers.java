class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int val : nums) map.put(val, map.getOrDefault(val, 0)+1);

        while(!map.isEmpty()){
            int val = map.firstKey();
            for(int i = 0; i < k; i++){
                int curr = val + i;
                if(!map.containsKey(curr)) return false;
                if(map.get(curr) == 1) map.remove(curr);
                else map.put(curr, map.get(curr)-1);
            }
        }
        return true;
    }
}