class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int j = 1;
            while (nums[i] != nums[i - 1] + j) {
                list.add(nums[i-1] + j);
                j++;
            }
        }
        return list;
    }
}