class Solution {
    public String removeOuterParentheses(String s) {
        
        if(s.isEmpty()){
            return "";
        }
        
        Deque<Character> st = new ArrayDeque<>();
        String output = "";
        
        for (int i =0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(st.size() == 0){
                st.push(ch);
            } else {
                
                if (ch == ')'){
                
                    st.pop();
                    
                } else{
                    
                    st.push(ch);
                }
                
                if(st.size() != 0) {
                    output += ch;
                }
            }
            
        }
        
        return output;
        
    }
}
