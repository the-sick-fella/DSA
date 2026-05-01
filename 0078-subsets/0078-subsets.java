class Solution {
    public List<List<Integer>> subsets(int[] nums) {
     List<Integer> curr = new ArrayList<>();
     List<List<Integer>> list = new ArrayList<>();
        add(list, nums, 0, curr);
        return list;
    }

    void add(List<List<Integer>> list, int [] nums, int i, List<Integer> curr){
        if(i >= nums.length){
            list.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        add(list, nums, i+1, curr);
        curr.remove(curr.size() - 1);
        add(list, nums, i+1, curr);
    }
}