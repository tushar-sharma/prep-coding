import java.util.HashSet;

public class UniqueString {

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
