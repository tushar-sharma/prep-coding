public class SB{
  public static void main(String[] args) {
    StringBuilder output = new StringBuilder();
    
    //fill everything with default value
    for (int i = 0; i < n; i++) {
        output.append('0');
    }
    //get ASCII value
    int val = output.charAt(j) - '0';
    
    //update value
    output.setCharAt(j, (char)(val + '0'));
  }
}
