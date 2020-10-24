/**
 * URL: https://leetcode.com/problems/restore-ip-addresses/
 */
class Solution {

  public static boolean isValid(String s) {


      if (s.length() > 1) {
          if(s.charAt(0) == '0') {
              return false;
          }
      }

      //conver to integer

      int sum = 0, factor = 1;

      for (char c : s.toCharArray()) {
          int sub = (int) c - 48;
          sum = sum * factor + sub;

          factor = 10;
      }

      if (sum > 255) {
          return false;
      }

      return true;

  }

  public static boolean checkValidIP(String s, int left, int right, int limit, String interim, List<String> output) {

      if (limit > 3) {
          return false;
      }

    if (right > s.length()) {
        return false;
    }
    if (!isValid(s.substring(left, right))) {
      return false;
    }



    if (interim.isEmpty()){
        interim  = s.substring(left, right);
    } else

        interim = interim + "." + s.substring(left, right);


     if (limit == 3 && right == s.length()) {

         output.add(interim);

        return true;
    }


    int start = right;

    for (int i = 1; i <= 3 ; i++) {
        if (!checkValidIP(s, start, start + i, limit + 1, interim, output)) {
        }

    }

    return false;

  }

  public static List<String> restoreIpAddresses(String s) {


      List<String> output = new ArrayList<>();
      String interm;

      int start = 0;

      for (int i = 1; i <= 3; i++) {

          if (!checkValidIP(s, start, start + i, 0, "", output)) {
          }

      }

      return output;

  }
}
