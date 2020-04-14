package questions.BestTime2BuyandSellStock2_0122;
/*
 * source: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * */
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length ; i++) {
            if (prices[i - 1]< prices [i]) {
                profit = profit + prices [i] - prices [i - 1];
            }
        }
        return profit;
    }
}
