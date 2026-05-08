class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        add(candidates, 0, target, new ArrayList<>(), list);
        return list;
    }

    void add(int[] nums, int idx, int target, List<Integer> curr, List<List<Integer>> list) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(curr);
            list.add(temp);
            return;
        }

        if (idx >= nums.length || nums[idx] > target)
            return;

        for (int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            add(nums, i + 1, target - nums[i], curr, list);
            curr.remove(curr.size() - 1);
        }
    }
}