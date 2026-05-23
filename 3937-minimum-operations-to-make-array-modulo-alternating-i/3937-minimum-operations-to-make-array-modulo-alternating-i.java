class Solution {
    public int minOperations(int[] nums, int k) {
        if(nums.length == 1) return 0;
        int ans = Integer.MAX_VALUE;
        for(int x = 0; x<k; x++){
            for(int y = 0; y<k; y++){
                if(x == y) continue;
                int count = 0;

                for(int i = 0; i<nums.length; i++){
                    int mod = nums[i] % k;
                    
                    if(i%2 == 0){
                        int diff = Math.abs(mod - x);
                        count += Math.min(diff, k-diff);
                    }
                    else{
                        int diff = Math.abs(mod - y);
                        count += Math.min(diff, k-diff);
                    }
                }

                ans = Math.min(ans, count);
            }
        }

        return ans;
    }
}