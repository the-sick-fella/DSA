class Solution {
    public int matchPlayersAndTrainers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}