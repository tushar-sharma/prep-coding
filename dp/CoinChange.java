/*
 * Find minimum number of coins
 * https://leetcode.com/problems/coin-change/
 */

public class CoinChange {

    /**
     * @ return minimum numbre of coins for the sum
     */
    private static int[] coins = {1, 2, 5};

    public static int countCoinChange(int target ) {

        if (target <= 0) {
            return 0;
        }
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
         smallest = Math.min(smallest, countCoinChange(target - coins[i]) + 1);
        }

        return smallest;
    }

    public static void main(String[] args) {
        assert countCoinChange(11) == 3;

        assert countCoinChange(0) == 0;

        assert countCoinChange(1) == 1;

    }
}
