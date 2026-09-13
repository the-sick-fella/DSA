class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        int ans = 0;
        for(int key : map.keySet()){
            List<Integer> list = map.get(key);
            if(list.size() != 3) continue;

            int one = list.get(0);
            int two = list.get(1);
            int three = list.get(2);
            if(three - two == two - one) ans++;
        }
        return ans;
    }
}