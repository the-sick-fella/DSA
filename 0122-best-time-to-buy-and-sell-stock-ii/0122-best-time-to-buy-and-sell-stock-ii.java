class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int buy = 0, sell = 0;
        for (int i = n - 1; i >= 0; i--) {
            int currBuy = 0, currSell = 0;
            currBuy = Math.max(nums[i] + sell, buy);
            currSell = Math.max(-nums[i] + buy, sell);
            buy = currBuy;
            sell = currSell;
        }
        return sell;
    }
}