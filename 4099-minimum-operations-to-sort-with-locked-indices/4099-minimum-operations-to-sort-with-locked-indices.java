class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {
        int n = nums.length, count = 0;
        for(int idx = 0; idx<n; idx++){
            if(idx>0 && nums[idx] < nums[idx-1]){
                int i = idx;
                while(i>0 && nums[i] < nums[i-1]){
                    if(locked[i] == 1){
                        if(k==0) return -1;
                        k--;
                        locked[i] = 0;
                        count++;
                    }
                    if(locked[i-1] == 1){
                        if(k==0) return -1;
                        k--;
                        locked[i-1] = 0;
                        count++;
                    }

                    int temp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = temp;
                    count++;
                    i--;
                }
            }
        }
        return count;
    }
}