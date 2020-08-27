import java.io.*;
import java.util.*;
/**
 * https://codeforces.com/contest/797/problem/C   
 */
public class Main{
 
    public static boolean isSmallExist(int[] characterHash, char elem) {
 
        int end_loc = elem; 
  
        for (int i = end_loc - 1; i >= 0; i--) {
            if (characterHash[i] > 0){
                return true;
            }
        }
 
 
        return false;
 
    }
 
    public static String findMinimalString(String s) {
 
        Stack<Character> t = new Stack<>();
 
        StringBuilder sb = new StringBuilder();
 
 
        int[] characterHash = new int[128];
 
        for (char ch : s.toCharArray()) {
            characterHash[ch]++;
        }
 
        int index = 0;
 
        while(index < s.length()){
  
            if (t.isEmpty()) {
                characterHash[s.charAt(index)]--;
                t.push(s.charAt(index++));
            } else {
 
                char curChar = t.peek(); 
                char nextChar = s.charAt(index);
 
                if (nextChar < curChar)  {
                    characterHash[s.charAt(index)]--;
                    t.push(s.charAt(index++));
                } else {
                     
                    if(!isSmallExist(characterHash, t.peek())) {
                        sb.append(t.pop());
                    } else if (isSmallExist(characterHash, s.charAt(index))) {
                        characterHash[s.charAt(index)]--;
                        t.push(s.charAt(index++));           
                    } else {
                        sb.append(t.pop());
                    }
 
                }
            }
 
        }
 
        while(!t.isEmpty()) {
            sb.append(t.pop()); 
        }
        
        return sb.toString();
 
    }
 
    public static void main(String[] args) throws IOException{
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        PrintWriter wr = new PrintWriter(System.out);
 
        String s = br.readLine();
 
        String minimalString = findMinimalString(s);
 
        wr.println(minimalString);
        wr.close();
        br.close();
        
        //assert findMinimalString("cab").compareTo("abc") == 0;
        //assert findMinimalString("acdb").compareTo("abdc") == 0;
        //assert findMinimalString("bababaaababaabbbbbabbbbbbaaabbabaaaaabbbbbaaaabbbbabaabaabababbbabbabbabaaababbabbababaaaaabaaaabbba").compareTo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb") == 0;
        //assert findMinimalString("dijee").compareTo("deeji") == 0;        
    }
}