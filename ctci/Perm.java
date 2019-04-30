import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Perm {

    //using brute force
    //O(nlogn)
    public static boolean checkPerm(String foo, String bar) {

        char[] fooArray = foo.toCharArray();
        char[] barArray = bar.toCharArray();

        Arrays.sort(fooArray);
        Arrays.sort(barArray);


        String newFoo = new String(fooArray);
        String newBar = new String(barArray);

        if (newFoo.equals(newBar)){
            return true;
        } else {
            return false;
        }
    }

    //using hash functions
    public static boolean checkPermHash(String foo, String bar) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char ch : foo.toCharArray()) {
            if(hashMap.containsKey(ch)) {
                int count = hashMap.get(ch);
                hashMap.put(ch, count+1);
            } else {
                hashMap.put(ch, 1);
            }
        }

        for (char ch : bar.toCharArray()) {
            if(hashMap.containsKey(ch)) {
                int count = hashMap.get(ch);
                hashMap.put(ch, count -1);
            }
        }

        //check if any hashmap contains nonzero value
        for(Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            Integer value = entry.getValue();

            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        assert  checkPerm("abc", "cba") == true;

        assert checkPerm("good", "dog") == false;

        assert checkPerm("new", "new") == true;

        assert checkPermHash("abc", "cba") == true;

        assert checkPermHash("good", "dog") == false;

        assert checkPermHash("new", "new") == true;

        //assert checkPerm("", "") == false;
    }
}
