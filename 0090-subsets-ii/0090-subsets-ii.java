class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        add(list, nums, 0, new ArrayList<>());

        return list;
    }

    void add(List<List<Integer>> list, int[] nums, int idx, List<Integer> curr) {
        list.add(new ArrayList<>(curr));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue;
            curr.add(nums[i]);
            add(list, nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}