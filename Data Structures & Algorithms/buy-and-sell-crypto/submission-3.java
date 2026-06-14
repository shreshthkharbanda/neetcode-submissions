class Solution {
    public int maxProfit(int[] prices) {
        // int l = 0;
        // int r = 1;
        int maxProfit = 0;
        for (int l = 0, r = 1; r < prices.length; r++) {
            if (prices[l] >= prices[r]) {
                l = r;
            } else {
                while (r < prices.length-1 && prices[r] < prices[r+1]) {
                    r++;
                }
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            }
        }

        return maxProfit;
    }
}
