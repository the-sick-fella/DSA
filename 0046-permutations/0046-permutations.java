class Solution {
    public List<List<Integer>> permute(int[] nums) {
     List<List<Integer>> list = new ArrayList<>();

     p(nums, 0, list);

     return list;   
    }

    void p(int [] nums, int idx, List<List<Integer>> list){
        if(idx >= nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num : nums) temp.add(num);
            list.add(temp);
            return;
        }

        for(int i = idx; i<nums.length; i++){
            swap(nums, i, idx);
            p(nums, idx+1, list);
            swap(nums, i, idx);
        }
    }


    void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}