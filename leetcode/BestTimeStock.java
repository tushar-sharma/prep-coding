/*
 ** leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeStock {

    public static int maxProfitBrute(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {

            for (int j = i + 1; j < prices.length; j++) {

                if (maximum < prices[j] - prices[i]) {
                    maximum = prices[j] - prices[i];
                }

            }
        }


        return (maximum < 0) ? 0 : maximum;

    }

    public static int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        int i = 0, j = 1;
        int maximum = prices[j] - prices[i];

        while (j < prices.length) {

            if (prices[j] - prices[i] > maximum) {
                maximum = prices[j] - prices[i];
            } else if(prices[i] > prices[j]) {
                i = j;
            }
            j++;
        }

        return (maximum < 0) ? 0 : maximum;

    }

    public static void main(String[] args) {

        assert maxProfitBrute(new int[]{7, 1, 5, 3, 6, 4}) == 5;

        assert maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5;

        assert maxProfitBrute(new int[]{2, 4, 1}) == 2;

        assert maxProfit(new int[]{2, 4, 1}) == 2;
    }
}
