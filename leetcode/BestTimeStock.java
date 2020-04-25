/*
 ** leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeStock {

    public static int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        int i = 0, j = 1, profit = 0;

        while (j < prices.length) {

            if (prices[j] - prices[i] > profit) {
                profit = prices[j] - prices[i];
            } else if(prices[i] > prices[j]) {
                i = j;
            }
            j++;
        }

        return profit;

    }

    public static void main(String[] args) {

        assert maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5;

        assert maxProfit(new int[]{2, 4, 1}) == 2;
    }
}
