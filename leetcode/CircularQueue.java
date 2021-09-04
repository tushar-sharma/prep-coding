class MyCircularQueue {
    
    private int[] queue;
    private int head, tail;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.head = -1;
        this.tail = -1;
    }
    
    public boolean enQueue(int value) {
        
        if (isFull()){
            return false;
        }
        
        else if (isEmpty()){
            this.head++;
            this.queue[++this.tail] = value;    
        }
        
        else { 
            this.tail = (this.tail + 1) % queue.length;
        
            queue[this.tail] = value;
        }
        
        return true;
        
    }
    
    public boolean deQueue() {
        
        if (isEmpty()) {
            return false;
        }
        
        else if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } 
        
        else {
            this.head = (this.head + 1)  % this.queue.length;
        }
        
        return true;
        
    }
    
    public int Front() {
        
        return isEmpty() ? -1 : this.queue[this.head];
        
    }
    
    public int Rear() {
        return isEmpty() ? -1 : this.queue[this.tail];
    }
    
    public boolean isEmpty() {
        if (this.head == -1 && this.tail == -1){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFull() {
        
        return ((this.tail + 1) % this.queue.length) == this.head;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
