import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

class Entry<K, V> {

    K key;
    V value;
    private int hash;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode(); //returns 32 bit integer
    }

    public boolean equals(Entry<K,V> other) {
        if (this.hash != other.hash) return false;

        return key.equals(other.key);
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int get_hash() {
        return hash;
    }
}

public class HashTable<K, V> {

    private int  capacity; //hash table size
    private static int DEFAULT_CAPACITY = 4;
    private int noElem; //number of key-value paris

    List<Entry<K,V>>[] bucket; //array of linked list

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {

        if (capacity < 0)
            throw new IllegalArgumentException("illegal capacity");

        this.capacity = capacity;
        this.noElem = 0;
        bucket = new LinkedList[this.capacity];
    }

    private List<Entry<K, V>>[] buckets;

    public int normalizeIndex(int keyHash) {
        return (keyHash & 0x7fffffff) % capacity;
        //0x7ffffffff = 0111 1111 1111 1111 ...
        //it will resul tin psoitive integer
        //so keyHash & 0x7fffffff will be in the range of capacity
    }

    /**
     * resize the bucket
     */
    public void resize(int capacity) {
        List<Entry<K,V>>[] newBucket = new LinkedList[capacity];
        List<Entry<K,V>>[] oldBucket = bucket;
        bucket = newBucket;

        for (int i = 0; i < this.capacity; i++) {
                newBucket[i] = oldBucket[i];
        }
        this.capacity = capacity;
    }

    /*
     * insert values into custom hash table
     * @param key   value insert into hash table
     * @param value value insert to corresponding key
     */

    public void put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("Null Key");

        //double if average lenght of list >= 10
        if (noElem >=  10 * capacity)
            resize(2 * capacity);

        Entry<K, V> newEntry = new Entry<>(key, value);

        int bucketIndex = normalizeIndex(newEntry.get_hash());

        bucketInsertEntry(bucketIndex, newEntry);
    }

    /**
     * insert the object at the bucketIndex of the bucket
     * @param bucketIndex  location of the inserted
     * @param entry object to be inserted
     */
    public V bucketInsertEntry(int bucketIndex, Entry<K,V> entry) {
        List<Entry<K,V>> bucketList = bucket[bucketIndex];

        if (bucketList == null) {
            bucket[bucketIndex] = bucketList = new LinkedList<>();
        } else {
            for (Entry<K,V> iter : bucket[bucketIndex]) {
                if (iter.getKey() == entry.getKey()) {
                    iter.setValue(entry.getValue());
                    return null;
                }
            }
        }

        bucketList.add(entry);
        return null;
    }

    /**
     * get the value of hash map for the corresponding key
     * @param key
     * @return value
     */
    public V get(K key) {
        if (key == null)
            return null;

        int bucketIndex = normalizeIndex(key.hashCode());

        Entry<K,V> entry = bucketSeek(bucketIndex, key);

        if (entry != null)
            return entry.value;

        return null;

    }

    /**
     * iterate over the linked list
     * @param list containing objects
     * @param object corresponding the key
     * @return the object for the key
     */

    public Entry<K,V> bucketSeek(int bucketIndex, K key) {
        if (key == null) {
            return null;
        }

        List<Entry<K,V>> bucketList = bucket[bucketIndex];

        if (bucketList == null)
            return null;

        for (Entry<K,V> iter : bucketList) {
            if (iter.key.equals(key)) {
                return iter;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        /*
         * Map<Integer, Integer> testMap = new HashMap<>();
         * testMap.put(1, 2);
         * testMap.put(2, 3);
         * testMap.put(3, 4);
         *
         * testMap.get(1) => 2
         */

        HashTable<Integer, Integer> hashTable = new HashTable<>();

        hashTable.put(1, 11);
        hashTable.put(2, 22);
        hashTable.put(3, 33);
        hashTable.put(1, 99);
        hashTable.put(4, 33);
        hashTable.put(5, 33);
        hashTable.put(6, 33);

        System.out.println(hashTable.get(6));
        System.out.println(hashTable.get(1));
    }
}
