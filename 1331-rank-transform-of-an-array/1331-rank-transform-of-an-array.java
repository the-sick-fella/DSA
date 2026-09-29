class Solution {
    public int[] arrayRankTransform(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int [] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int rank = 1;
        for(int i = 0; i<temp.length; i++){
            List<Integer> list = map.get(temp[i]);
            for(int idx : list) nums[idx] = rank;
            rank++;
            while(i < temp.length - 1 && temp[i] == temp[i+1]) i++;
        }

        return nums;
    }
}