/**
Things to remember:
1. Spilt a string by dot requires double slash
2. Get actual value of a number from character
   int val = (int) c - 48;
3. Split function needs -1 to return trailing empty strings
4. Inbuilt functions like
  Character.isDigit()
  Character.isLetter()
  Character.isLetterOrDigit()
*/
class Solution {

    public boolean checkIPv4(String queryIP) {

        String[] queryIPArray = queryIP.split("\\.", -1);

        if (queryIPArray.length != 4) {
            return false;
        }

        for(String query : queryIPArray) {

            if (query.isEmpty()){
                return false;
            }

            if (query.length() > 1 && query.charAt(0) == '0'){
                return false;
            }

            int val = 0;
            int factor = 1;
            for (char c : query.toCharArray()) {

                if (!Character.isDigit(c)) {
                    return false;
                }

                val = (val * factor)  + (int) c - 48;

                factor = 10;
            }

            if (val < 0 || val > 255) {
                return false;
            }

        }

        return true;


    }

    public boolean checkIPv6(String queryIP) {
        String[] queryIPArray = queryIP.split("\\:", -1);


        if (queryIPArray.length != 8) {
            return false;
        }

        for(String query : queryIPArray) {

            if (query.length() < 1 || query.length() > 4){
                return false;
            }

            for (char c : query.toCharArray()) {
                if (! ((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || (c >= '0' && c <= '9')) ){
                    return false;
                }
            }


        }

        return true;
    }

    public String validIPAddress(String queryIP) {

        if (checkIPv4(queryIP)){
            return "IPv4";
        } else if (checkIPv6(queryIP)){
            return "IPv6";
        } else {
            return "Neither";
        }

    }
}
