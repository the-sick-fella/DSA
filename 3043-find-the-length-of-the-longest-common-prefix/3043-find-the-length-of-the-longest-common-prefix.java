class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : arr1) {
            while (val > 0) {
                set.add(val);
                val /= 10;
            }
        }

        int ans = 0;
        for (int val : arr2) {
            while (val > 0) {
                if (set.contains(val)) {
                    ans = Math.max(ans, String.valueOf(val).length());
                }
                val /= 10;
            }
        }

        return ans;
    }
}