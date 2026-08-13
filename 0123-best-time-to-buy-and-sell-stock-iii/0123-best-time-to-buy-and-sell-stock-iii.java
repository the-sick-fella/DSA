class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int[] sellDp = new int[3];
        int[] buyDp = new int[3];

        for (int i = n - 1; i >= 0; i--) {
            int currSell[] = new int[3];
            int currBuy[] = new int[3];
            // for (int bought = 1; bought >= 0; bought--) {
                for (int count = 2; count >= 0; count--) {
                    // if (bought == 1) {
                        int sell = nums[i] + sellDp[count];
                        int hold = buyDp[count];
                        currBuy[count] = Math.max(sell, hold);
                    // } else {
                        if (count == 2)
                            currSell[count] = 0;
                        else {
                            int buy = -nums[i] + buyDp[count + 1];
                            int skip = sellDp[count];
                            currSell[count] = Math.max(buy, skip);
                        }
                    // }
                }
            // }
            // dp = temp;
            buyDp = currBuy;
            sellDp = currSell;
        }
        return sellDp[0];
    }
}