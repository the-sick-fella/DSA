class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, list, new ArrayList<>(), new ArrayList<>());
        return list;
    }

    void f(int [] nums, List<List<Integer>> list, List<Integer> curr, List<Integer> visited){ 
        if(curr.size() == nums.length){
            list.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(visited.contains(i)) continue;
            if(i>0 && !visited.contains(i-1) && nums[i] == nums[i-1]) continue;

            curr.add(nums[i]);
            visited.add(i);
            f(nums, list, curr, visited);
            curr.remove(curr.size()-1);
            visited.remove(visited.size()-1);
        }
    }
}