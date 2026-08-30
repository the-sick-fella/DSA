class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        int best = compute(nums, -1);

        for(int i = 0; i<n; i++){
            best = Math.max(best, compute(nums, i));
        }
        return best;
    }

    int compute(int [] nums, int idx){
        int n = nums.length;
        int m = (idx == -1)?n : n-1;
        if(m<=1) return 0;

        int [] nums2 = new int[m];
        int idx2 = 0;
        for(int i = 0; i<n; i++){
            if(i == idx) continue;
            nums2[idx2++] = nums[i];
        }

        int [] pre = new int[m], suf = new int [m];

        pre[0] = nums2[0];
        for(int i = 1; i<m; i++){
            pre[i] = gcd(pre[i-1], nums2[i]);
        }

        
        suf[m-1] = nums2[m-1];
        for(int i = m-2; i>=0; i--){
            suf[i] = gcd(suf[i+1], nums2[i]);
        }

        int count = 0;
        for(int i = 0; i<m-1; i++){
            if(pre[i] == suf[i+1]) count++;
        }

        return count;
    }

    int gcd(int a, int b){
        while(b > 0){
            int t = b;
            b = a%b;
            a = t;
        }
        return a;
    }
}