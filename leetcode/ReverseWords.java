/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
class ReverseWords {
    public static String reverseWords(String s) {

        if (s.isEmpty()) {
            return "";
        }

        String[] sArray = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();


        String sep = "";
        for (int i = sArray.length - 1; i >= 0; i--) {
            sb.append(sep + sArray[i]);
            sep = " ";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("some randomw string"));
    }
}
