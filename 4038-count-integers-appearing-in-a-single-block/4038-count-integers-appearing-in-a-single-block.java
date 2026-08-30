class Solution {
    public int countSpecialIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            if(set2.contains(nums[i])) continue;
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                while(i<nums.length-1 && nums[i] == nums[i+1]) i++;
            } else{
                set.remove(nums[i]);
                set2.add(nums[i]);
            }
        }

        return set.size();
    }
}