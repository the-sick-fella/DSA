class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        f(nums, set, new ArrayList<>(), new ArrayList<>());
        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> curr : set) list.add(new ArrayList<>(curr));
        return list;
    }

    void f(int [] nums, Set<List<Integer>> set, List<Integer> curr, List<Integer> visited){
        if(curr.size() == nums.length){
            set.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(visited.contains(i)) continue;

            curr.add(nums[i]);
            visited.add(i);
            f(nums, set, curr, visited);
            curr.remove(curr.size()-1);
            visited.remove(visited.size()-1);
        }
    }
}