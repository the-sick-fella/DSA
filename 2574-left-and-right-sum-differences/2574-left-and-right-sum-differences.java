class Solution {
    public int[] leftRightDifference(int[] nums) {
        int ls = 0;
        int rs = 0;

        int i = 0;
        for(; i<nums.length; i++){
            ls += nums[i];
        }   

        i--;

        int temp [] = new int[nums.length];
        for(; i>=0; i--){
            ls -= nums[i];
            temp[i] = Math.abs(ls - rs);
            rs += nums[i];
        }

        return temp;
    }
}