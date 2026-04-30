class Solution {
    public int[] sortArray(int[] nums) {
        qs(nums, 0, nums.length-1);
        return nums;
    }

    void qs(int [] nums, int low, int high){
        if(low >= high) return;
        int idx = partition(nums, low, high);

        qs(nums, low, idx-1);
        qs(nums, idx+1, high);
    }

    int partition(int [] nums, int low, int high){
        int pv = nums[low];

        int i = low;
        int j = high;

        while(i < j){
            while(nums[i]<= pv && i<high) i++;
            while(nums[j]> pv && j>low) j--;

            if(i<j) swap(nums, i, j);
        }

        swap(nums, j, low);
        return j;
    }

    void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}