class Node{
    int frequency;
    int value;

    public Node(int value, int frequency){
        this.frequency = frequency;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public int getFrequency() {
        return this.frequency;
    }
}

class LRUCache {

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        if(map.get(key) == null) {
            return -1;
        } else {
            map.put(key, new Node(map.get(key).getValue(), this.size++));
            return  map.get(key).getValue();

        }
    }

    public void put(int key, int value) {

        if (map.get(key) == null) {

            this.capacity--;

            if (this.capacity < 0) {

                int minimumLRU = Integer.MAX_VALUE;
                int deleteKey = 0;


                for(Map.Entry<Integer, Node> entry : map.entrySet()) {
                    if (entry.getValue().getFrequency() < minimumLRU) {
                        minimumLRU = entry.getValue().getFrequency();
                        deleteKey = entry.getKey();

                    }
                }

              map.remove(deleteKey);

            }

        }

        map.put(key, new Node(value, this.size++));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
