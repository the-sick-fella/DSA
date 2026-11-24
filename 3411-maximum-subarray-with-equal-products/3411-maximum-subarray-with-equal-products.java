class Solution {
    public int maxLength(int[] nums) {
        int maxLength = 0;
        int n = nums.length;

        for (int start = 0; start < n; start++) {
            long product = nums[start];
            int currentGCD = nums[start];
            long currentLCM = nums[start];

            for (int end = start+1; end < n; end++) {
                product *= nums[end];
                currentGCD = gcd(currentGCD, nums[end]);
                currentLCM = lcm(currentLCM, nums[end]);

                if (product == currentGCD * currentLCM) {
                    maxLength = Math.max(maxLength, end - start + 1);
                } else {
                    break;
                }
            }
        }

        return maxLength;
    }
       
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(long a, int b) {
        return (a / gcd((int) a, b)) * b;
    }

}