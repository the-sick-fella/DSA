class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int val : hand) map.put(val, map.getOrDefault(val, 0)+1);

        while(!map.isEmpty()){
            int val = map.firstKey();
            for(int i = 0; i < groupSize; i++){
                int curr = val + i;
                if(!map.containsKey(curr)) return false;
                if(map.get(curr) == 1) map.remove(curr);
                else map.put(curr, map.get(curr)-1);
            }
        }
        return true;
    }
}