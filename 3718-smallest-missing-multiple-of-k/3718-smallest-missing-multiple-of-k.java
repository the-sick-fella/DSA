class Solution {
    public int missingMultiple(int[] nums, int k) {
        int [] f = new int[101];
        for(int num : nums) {
            if(num % k == 0) f[num/k]++;
        }
        int i = 1;
        while(i<f.length && f[i] > 0){
            i++;
        } 
        return k*i;
    }
}