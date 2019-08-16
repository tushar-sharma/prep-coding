/* design a hashMap
 * fn(arbitrary string) = constant hash
 * Map<Integer, Integer> myHashMap = new HashMap<>();   // { }
 * myHashMap.put(1, 100);            // { 1 => 100}
 * myHashMap.put(2, 200);           // { 1 => 100, 2 => 200}
 * myHashMap.get(1)                // print 100
 * myHashMap.put(1, 300);          // { 1 => 300, 2 => 200}
 * myHashMap.get(1)               //  print 300
 * */
import java.util.List;
import java.util.LinkedList;

class HashClass<K, V> {
    K key;
    V value;
    private int hash;

    public HashClass(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }

    public int getHash() {
        return hash;
    }

    public void setValue(V value) {
        this.value = value;
    }

}

public class MyHashMap <K, V>{

    private List<HashClass<K,V>>[] bucket;
    double load_factor = 0.75;
    int bucket_size_m = 10;
    static int items_n = 0;

    public static void inc_n() {
        items_n = items_n + 1;
    }

    public MyHashMap() {
        bucket  = new LinkedList[this.bucket_size_m];
    }

    public void resize() {
        System.out.println("I'm here");
        List<HashClass<K,V>>[] newBucket = new LinkedList[this.bucket_size_m * 2];

        for (int i = 0; i < bucket_size_m; i++) {
            List<HashClass<K,V>> bucketList = bucket[i];
            List<HashClass<K,V>> newBucketList = newBucket[i] = new LinkedList<>();
            if (bucketList != null) {
                for (HashClass<K,V> iterClass : bucketList) {
                    newBucketList.add(iterClass);
                }
            }
        }

        bucket = newBucket;
        this.bucket_size_m = bucket_size_m * 2;
    }

    /**
     * @param key : key for hashmap
     * @param value : value for hashMap
     * @return None
     */
    public void put(K key, V value) {
        //base case
        //TODO : later if key == null\
        if (key == null) {
            return;
        }

       // if (items_n > (10 * bucket_size_m) )
       if (items_n == 2)
            resize();

        HashClass<K, V> hashObj = new HashClass(key, value);
        int bucketIndex = normalize(hashObj.getHash());
        bucketInsert(hashObj, bucketIndex);
    }

    /**
     * insert object into bucket
     */
    public void bucketInsert(HashClass<K,V> hashObj, int bucketIndex) {
        List<HashClass<K, V>> bucketList = bucket[bucketIndex];

        if (bucketList == null) {
            bucket[bucketIndex] = bucketList = new LinkedList<>();
            bucketList.add(hashObj);
        } else{

            for (HashClass<K,V> iterClass : bucketList) {
                if (iterClass.key.equals(hashObj.key)) {
                    iterClass.setValue(hashObj.value);
                }
            }
        }
    }

    /*
     *@param bucketIndex
     * param key
     */
    public HashClass<K, V> seekBucketEntry(int bucketIndex, K key) {

        if (key == null)
            return null;

        List<HashClass<K,V>> bucketList = bucket[bucketIndex];

        if (bucketList == null) {
            return null;
        }
        for (HashClass<K, V> iterClass : bucketList) {
            if (iterClass.key.equals(key)){
                return iterClass;
            }
        }

        return null;
    }

    /*
     * @param key the key for the hashmap
     * @return corresponding value
     */
    public V get(K key) {
        if (key == null) {
            return null;
        }

        int bucketIndex = normalize(key.hashCode());
        HashClass<K,V> hashObj = seekBucketEntry(bucketIndex, key);

        if (hashObj != null) {
            return hashObj.value;
        }
        else {
            return null;
        }
    }

    /**
     * return normalized bukcet index
     * @param  hashValue the hash of the key
     * @return the normalize index
     */
    public int normalize(int hashValue) {
        return (hashValue & 0x7fffffff) % bucket_size_m;
    }

    public static void main(String[] args) {

        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        System.out.println("puttin  1");
        myHashMap.put(1, 100);
        MyHashMap.inc_n();
        System.out.println("puttin  2");
        myHashMap.put(2, 200);
        MyHashMap.inc_n();
        System.out.println("puttin  1");
        myHashMap.put(1, 300);
        myHashMap.inc_n();
        System.out.println(myHashMap.get(2)); //200
        System.out.println(myHashMap.get(1)); //200

    }
}

