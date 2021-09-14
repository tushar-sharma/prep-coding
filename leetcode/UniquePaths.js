/**
 Remember 
 1. how to create 2D array in js
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    if (m == 1 && n ==1 ) {
        return 1;
    }
    
    const dp = new Array(m).fill(1).map( () => new Array(n).fill(1));
        
    for (var i = 1; i < m; i++){
        for (var j = 1; j < n; j++) {
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        }
    }
    
    return dp[m - 1][n - 1];
    
};
