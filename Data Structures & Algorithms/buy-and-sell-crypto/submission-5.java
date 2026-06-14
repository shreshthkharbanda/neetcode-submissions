class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int l = 0, r = 1; r < prices.length; r++) {
            if (prices[l] >= prices[r]) {
                l = r;
            } else {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            }
        }

        return maxProfit;
    }
}
