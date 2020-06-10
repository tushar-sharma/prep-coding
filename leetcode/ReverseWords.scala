/*
 ** https://leetcode.com/problems/reverse-words-in-a-string/
 */
object Solution {
    def reverseWords(s: String): String = {

        if(s.isEmpty) {
            return ""
        }

        val sArray = s.trim.split("\\s+")
        var output = "";
        var sep = "";

        val arrayRange = sArray.size - 1

        for (i <- arrayRange to 0 by -1) {
            output = output + sep + sArray(i)
            sep = " "
        }

        return output
    }
}
