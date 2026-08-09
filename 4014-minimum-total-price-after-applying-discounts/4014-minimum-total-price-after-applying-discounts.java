class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int j = discounts.length-1;
        double sum = 0;
        for(int i = prices.length-1; i>=0; i--){
            if(j>=0) {
                sum += (double)((prices[i] * (double)(100 - discounts[j])) / 100);
                j--;
            }
            else sum+=prices[i];
        }

        return sum;
    }
}