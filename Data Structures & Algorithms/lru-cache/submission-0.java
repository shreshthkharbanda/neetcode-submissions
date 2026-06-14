class LRUCache {
    // last used - key
    LinkedHashMap<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() >= capacity) {
            Map.Entry<Integer, Integer> firstEntry = map.entrySet().iterator().next();
            map.remove(firstEntry.getKey());
        }
        map.put(key, value);
    }
}
