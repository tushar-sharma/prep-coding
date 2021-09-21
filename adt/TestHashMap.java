import java.util.*;

/*
 * Remember
 * containsKey is O(1)
 * containsValue is O(n)
 * Iterating over hashmap
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("a", 100);
        map.put("b", 200);
        map.put("c", 300);

        //get key
        System.out.println("key for b is " + map.getOrDefault("b", 0));

        System.out.println("key for z is " + map.getOrDefault("z", 0));

        if (map.containsKey("a")) {
            System.out.println("a exist as key");
        }

        if (map.containsValue(100)) {
            System.out.println("100 exist as value");
        }

        map.forEach ( (key, value) -> {
            System.out.println("key is " + key + " value is " + value);
        });

    }
}
