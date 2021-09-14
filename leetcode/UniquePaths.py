"""
Remember:
1. How to declare 2d array
2. Iterate 2D array
"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        if m == n == 1:
            return 1;
        
        dp = [[1] * n for i in range(m)]
        
        for row in range(1, len(dp)):
            for col in range(1, len(dp[row])):
                
                dp[row][col] = dp[row][col - 1] + dp[row - 1][col]
                
                
        return dp[m - 1][n - 1]
