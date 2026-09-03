class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        boolean even = nums1[0] % 2 == 0 ? true : false;

        for(int num : nums1){
            if(even && num%2 != 0) return false;
        }
        return true;
    }
}