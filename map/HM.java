import java.util.Map;
import java.util.HashMap;

class HM {
    public static void main(String[] args) {
        Map<Integer, Integer> myMap = new HashMap<>();
        myMap.put(1, 1);
        myMap.put(2, 5);

        //Only the keys
        for(Integer key : myMap.keySet()) {
            System.out.println(key);
        }

        //only the values
        for (Integer value : myMap.values()) {
            System.out.println(value);
        }

        //both key, value
        for(Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println("key " + key +  " value " + value);
        }
    }
}
