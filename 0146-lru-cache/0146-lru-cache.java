class LRUCache {

    class Node {
        Node prev;
        Node next;
        int key;
        int value;
    }

    private Node head;
    private Node tail;
    private final int totalCapacity;
    private int currentCapacity;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.prev = head.next = tail;
        tail.prev = tail.next = head;
        tail.key = head.key = -1;
        tail.value = head.value = 0;
        this.totalCapacity = capacity;
        this.currentCapacity = 0;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        // System.out.println("GET : "+key);
        if(map.get(key) != null) {
            Node node = map.get(key);
            int value = node.value;
            remove(key);
            insert(key, value);
            // System.out.println("");
            return value;
        }
        // System.out.println("");
        return -1;
    }

    private void insert(int key, int value) {
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        head.next.prev = newNode;
        newNode.next = head.next;
        head.next = newNode;
        newNode.prev = head;
        map.put(key, newNode);
        currentCapacity++;
        // print("INSERT");
    }

    private void remove(int key) {
        //I'm sure that key exists
        Node node = map.get(key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        map.remove(key);
        currentCapacity--;
        // print("REMOVE");
    }

    private void print(String s) {
        System.out.print(s + " : ");
        Node node = head;
        while(node!=tail) {
            System.out.print("("+node.key+") ");
            node = node.next;
        }
        System.out.println();
    }
    
    public void put(int key, int value) {
        // System.out.println("PUT : "+key + " " + value + " " + currentCapacity + " ");

        if(map.get(key) != null) {
            remove(key);
        }
        if(currentCapacity == totalCapacity) {
            remove(tail.prev.key);
        }
        
        insert(key, value);
        // System.out.println();
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */