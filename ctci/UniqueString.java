import java.util.HashSet;
/**
 * Check if a string has unique characters
 */
public class UniqueString {

    /* with using extra data structure */
    public static boolean isUnique(String inputString) {

        HashSet<Character> hashSet = new HashSet<>();

         for(char iter : inputString.toCharArray()) {
             if(hashSet.contains(iter)) {
                 return false;
             } else {
                 hashSet.add(iter);
             }
         }

        return true;
    }

    public static void main(String[] args) {
        assert isUnique("abcdefghabc") == false;

        assert isUnique("zytblc su") == true;

       // assert isUnique("") == false;
    }
}
