class Solution {
    public String[] largestString(int[] nums) {
        int n = nums.length;
        String[] ans = new String[n];
        for(int i = 0; i<n; i++){
            ans[i] = getString(nums[i]);
        }
        return ans;
    }

    String getString(int n){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<25 && n>0){
            int rem = n%2;
            if(rem != 0) sb.append((char)('a' + i));
            i++;
            n/=2;
        }

        for(int j = 0; j<n; j++) sb.append('z');
        return sb.reverse().toString();
    }
}