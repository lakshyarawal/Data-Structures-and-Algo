import java.util.Random;
class MyHashSet {
    int[] set;
    int MOD;
    public MyHashSet() {
        Random random = new Random();
        set = new int[1000000];
        MOD = random.nextInt(1000000);
    }
    
    public void add(int key) {
        set[key%MOD] = 1;
    }
    
    public void remove(int key) {
        set[key%MOD] = 0;
    }
    
    public boolean contains(int key) {
        return set[key%MOD] != 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */