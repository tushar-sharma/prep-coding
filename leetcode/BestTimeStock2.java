/*
 ** leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

public class BestTimeStock2 {

    public static int maxProfit(int[] prices) {

        int left = 0;
        int right = prices.length - 1;

        int profit = 0;

        for (int i = left + 1; i <= right; i++) {

            int diff = prices[i] - prices[i - 1];

            if (diff > 0) {
                profit += diff;

            }
        }

        return profit;

    }


    public static void main(String[] args) {

        assert maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 7;

        assert maxProfit(new int[]{1,2,3,4,5}) == 4;
    }
}
