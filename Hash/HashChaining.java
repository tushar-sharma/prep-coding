import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

class Entry <Key, Value> {

    private int hash;
    Key key;
    Value val;

    public Entry(Key key, Value val) {
        this.key = key;
        this.val = val;
        this.hash = key.hashCode();
    }

    public int get_hash() { return hash; }

    public boolean equals(Entry<Key, Value> other) {
        if (hash != other.hash) return false;
        return key.equals(other.key);
    }

    @Override public String toString() {
        return key + " => " + val;
    }
}

@SuppressWarnings("unchecked")
public class HashChaining<Key,Value>  {

    private LinkedList<Entry<Key,Value>>[] bucket;
    private static final double DEFAULT_LOAD_FACTOR = 0.75; //optimum
    private static final int DEFAULT_CAPACITY = 3;
    private double maxLoadFactor;
    private int capacity, threshold, size = 0;


    public HashChaining() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashChaining(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public HashChaining(int capacity, double maxLoadFactor) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal capacity");
        if (maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor))
            throw new IllegalArgumentException("Illegal maxLoadFactor");

        this.maxLoadFactor = maxLoadFactor;
        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        threshold = (int) (this.capacity * maxLoadFactor);
        bucket = new LinkedList[this.capacity];
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    private int normalizeIndex(int keyHash) {
        return (keyHash & 0x7fffffff) % capacity;
    }

    public void clear() {
        Arrays.fill(bucket, null) ;
        size = 0;
    }


    public Value put(Key key, Value val) {
        return insert(key, val);
    }


    public Value insert(Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("Null key");

        Entry<Key, Value> newEntry = new Entry<>(key, val);
        int bucketIndex =  normalizeIndex(newEntry.get_hash());
        return bucketInsertEntry(bucketIndex, newEntry);
    }

    private Value bucketInsertEntry(int bucketIndex, Entry<Key, Value> entry) {
        LinkedList<Entry<Key,Value>> bucketList = bucket[bucketIndex];

        if (bucketList == null) {
            bucket[bucketIndex] = bucketList = new LinkedList<>();
        }

        bucketList.add(entry);

        return null;
    }

    public Value get(Key key) {
        if (key == null)
            return null;

        int bucketIndex = normalizeIndex(key.hashCode());

        Entry<Key,Value> entry = bucketSeekEntry(bucketIndex, key);
        if (entry != null)
            return entry.val;

        return null;
    }

    public Entry<Key, Value> bucketSeekEntry(int bucketIndex, Key key) {
        if (key == null) {
            return null;
        }
        LinkedList<Entry<Key,Value>> bucketList = bucket[bucketIndex];

        if (bucketList == null) return null;

        for (Entry<Key,Value> entry : bucketList) {
            if (entry.key.equals(key))
                return entry;
        }
        return null;
    }

    public static void main(String[] args) {

        Map<String, Integer> testMap = new HashMap<>();

        testMap.put("one", 1);
        testMap.put("two", 2);
        testMap.put("three", 3);

        System.out.println("(Key,value)=(two," + testMap.get("two") + ")");
        System.out.println("(Key,value)=(three," + testMap.get("three") + ")");

        HashChaining<String, Integer> hashChain = new HashChaining<>();
        hashChain.put("one", 1);
        hashChain.put("two", 2);
        hashChain.put("three", 3);

        System.out.println("(Key,value)=(two," + hashChain.get("two") + ")");
        System.out.println("(Key,value)=(three," + hashChain.get("three") + ")");
    }
}
