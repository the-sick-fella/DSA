class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if(low >= high) return;
        
        int idx = partition(arr, low, high);
        quickSort(arr, low, idx-1);
        quickSort(arr, idx+1, high);
    }

    private int partition(int[] nums, int low, int high) {
        // code here
        int pv = nums[high];
        int i = low;
        int j = high;
        
        while(i<j){
            while(i<high && nums[i] < pv) i++;
            while(j>low && nums[j] >= pv) j--;
            
            if(i<j) swap(nums, i, j);
        }
        
        swap(nums, high, i);
        return i;
    }
    
    void swap(int [] nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}