class Solution {
    public boolean rotateString(String s, String goal) {
        
        if (s.length() != goal.length()){
            return false;
        }
        
        if (s.equals(goal)){
            return true;
        }
                      
        return (s + s).contains(goal);    
    }

    public boolean rotateStringBrute(String s, String goal) {
        
        if (s.length() != goal.length()){
            return false;
        }
        
        if (s.equals(goal)){
            return true;
        }
        
        int n = s.length();        
        String result = "";
        
        for (int i = 0 ; i < n ; i++) { 
            result = s.substring(i) + s.substring(0, i);
            if (result.equals(goal)){
                return true;
            }
            
        }    
        return false;       
    }
}