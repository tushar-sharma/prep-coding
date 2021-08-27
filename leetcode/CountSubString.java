
class Solution {

    public boolean isPalindromic(String s) {

        StringBuilder sb = new StringBuilder(s);
        
        return sb.toString().equals(sb.reverse().toString());
    }

    public int countSubstrings(String s) {

        if (s.length() == 1){
            return 1;
        }

        int count = 0;
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for (int g = 0; g < s.length(); g++) {
             
            for (int i = 0; (i + g) < s.length() ; i++) {
                
                if  (g == 0){
                    dp[i][i + g] = true;
                }
                
                else if (g == 1){
                    dp[i][i + g] = s.charAt(i) == s.charAt(i + g );
                } 
                 
                else {
                    if (s.charAt(i) == s.charAt(i + g ) && dp[i + 1][i + g - 1] == true) {
                        dp[i][i + g] = true;
                        
                    }
                }
                
                if (dp[i][i + g] == true){
                    count++;
                }
                
            }
        }

        return count;
        
    }
}
