class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int maxP = 0;
        for (int i = 0, j = 1; j < prices.length; j++) {
            if (prices[j] > prices[i]) {
                maxP = Math.max(prices[j] - prices[i], maxP);
            } else {
                i = j;
            }
        }

        return maxP;
    }
}
