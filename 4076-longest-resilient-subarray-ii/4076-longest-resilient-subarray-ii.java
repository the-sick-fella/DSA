class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 1, i = 0;
        while (i < n) {
            int r = nums[i] % k;
            int j = i;
            while (j < n && nums[j] % k == r)
                j++;
            int m = j - i;
            int s = k / gcd(r, k);
            int l = 1 + ((m - 1) / s) * s;
            ans = Math.max(ans, l);
            i = j;
        }
        return ans;
    }

    int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}