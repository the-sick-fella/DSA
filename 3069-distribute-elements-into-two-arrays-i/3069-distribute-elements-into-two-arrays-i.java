class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();

        l1.add(nums[0]);
        l2.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (l1.get(l1.size() - 1) > l2.get(l2.size() - 1)) {
                l1.add(nums[i]);
            } else {
                l2.add(nums[i]);
            }
        }

        int i = 0;
        while (i < l1.size()) {
            nums[i] = l1.get(i);
            i++;
        }

        for (int j = 0; j < l2.size(); j++) {
            nums[i + j] = l2.get(j);
        }

        return nums;
    }
}