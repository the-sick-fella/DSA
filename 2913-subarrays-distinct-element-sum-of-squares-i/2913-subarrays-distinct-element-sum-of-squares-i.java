class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(nums.get(i));
            for (int j = i; j < n; j++) {
                set.add(nums.get(j));
                int s = set.size();
                ans += s * s;
            }
        }
        return ans;
    }
}