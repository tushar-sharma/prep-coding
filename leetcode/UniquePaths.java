/**
 * Remember: 
   1. Initialize the 2d array with 1
   2. start with 1,1
 */
class Solution {
    public int uniquePaths(int m, int n) {
        
        if (m == 1 && n == 1) {
            return 1;
        }
        
        int[][] dp = new int[m][n];
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j  < n; j++){
                dp[i][j] = 1;
            }
        }
        
        
        for (int i = 1; i < m; i++) {
            for (int j  = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        
        return dp[m - 1][n - 1];
        
    }
}
