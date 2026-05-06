class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        find(candidates, 0, target, list, ans);
        return ans;
    }

    void find(int[] nums, int idx, int target, List<Integer> list, List<List<Integer>> ans) {
        if (idx >= nums.length) {
            if (0 == target) {
                List<Integer> temp = new ArrayList<>(list);
                ans.add(temp);
            }
            return;
        }

        if (target >= nums[idx]) {
            list.add(nums[idx]);
            find(nums, idx, target - nums[idx], list, ans);
            list.remove(list.size() - 1);
        }

        find(nums, idx + 1, target, list, ans);
    }
}