class Solution {
    public int minimumSwaps(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while(i<j){
            while(i<nums.length && nums[i] != 0) i++;
            while(j>=0 && nums[j] == 0) j--;

            if(i<j){
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}