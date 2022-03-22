class Solution {
    
    public boolean isPalindrome(String s){
        int n = s.length();
        
        for (int i = 0 ; i < (n / 2); i++){
            if (s.charAt(i) != s.charAt(n - i -1)){
                return false;
            }
        }
        return true;
    }
    
    List<List<String>> output = new ArrayList<>();
    
    public void getPartition(String s, List<String> res){
        
        if (s.isEmpty()){
           output.add(res);
           return;
        }
        
        for (int i = 0; i < s.length(); i++){
            String prefix = s.substring(0, i + 1);
            String suffix = s.substring(i + 1);
            
            if (isPalindrome(prefix)){
                List<String> tempRes = new ArrayList<>(res);
                tempRes.add(prefix);
                getPartition(suffix, tempRes);
            }
        }
        
    }
    
    public List<List<String>> partition(String s) {        
        
        List<String> res = new ArrayList<>();
        
        getPartition(s, res);
        
        return output;
    }
}