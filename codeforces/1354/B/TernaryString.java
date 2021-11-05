import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Main{
    
     public static int getTernaryString(String s) {
         
         int count = Integer.MAX_VALUE;
         int[] index = new int[3];   
         int left = 0;
         
         for (int right = 0; right < s.length(); right++) { 
             index[s.charAt(right) - 49] += 1;
             
             while (index[s.charAt(left) - 49] > 1) {
                 index[s.charAt(left) - 49] -= 1;
                 left++;
             }
             
             if (index[0] != 0 && index[1] != 0 && index[2] != 0) {
                 count = Math.min(count, right -left + 1);
             }
             
         }

         return count == Integer.MAX_VALUE ?  0 : count;
     } 
     

     public static void main(String []args) throws IOException {
         
         BufferedReader br = new BufferedReader(
                                 new InputStreamReader(System.in));
         
         PrintWriter wr = new PrintWriter(System.out);
         
         int testCase = Integer.parseInt(br.readLine());
         
         while (testCase-- > 0 ) {
             
             wr.println(getTernaryString(br.readLine()));
             
         }
         wr.close();
         br.close();
     }
}
