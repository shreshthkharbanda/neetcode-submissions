class MyHashSet {

    List<Integer>[] set;
    // List<Integer> list;

    public MyHashSet() {
        set = new List[10000];
        for (int i = 0; i < set.length; i++) {
            set[i] = new LinkedList<>();
        }
    }
    
    public void add(int key) {
        List<Integer> list = set[key % set.length];
        if (list.contains(key)) return;
        list.add(key);
    }
    
    public void remove(int key) {
        List<Integer> list = set[key % set.length];
        list.remove((Integer) key);
    }
    
    public boolean contains(int key) {
        List<Integer> list = set[key % set.length];
        for (int i : list) {
            if (i == key) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */