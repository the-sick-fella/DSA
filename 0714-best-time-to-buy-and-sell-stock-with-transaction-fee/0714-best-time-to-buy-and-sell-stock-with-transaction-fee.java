class Solution {
    public int maxProfit(int[] nums, int fee) {
        int n = nums.length;
        int bought = 0, sold = 0;
        for (int i = n - 1; i >= 0; i--) {
            int currBuy = 0, currSell = 0;

            int sell = nums[i] - fee + sold;
            int hold = bought;
            currBuy = Math.max(sell, hold);

            int buy = -nums[i] + bought;
            int skip = sold;
            currSell = Math.max(buy, skip);

            bought = currBuy;
            sold = currSell;
        }
        return sold;
    }
}