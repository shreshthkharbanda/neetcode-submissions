class MyHashMap {

    LinkedList<Node>[] map;

    public MyHashMap() {
        map = new LinkedList[10000];
        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }
    }
    
    public void put(int key, int value) {
        LinkedList<Node> list = map[key % map.length];
        for (Node n : list) {
            if (n.key == key && n.val == value) {
                return;
            } else if (n.key == key && n.val != value) {
                n.val = value;
                return;
            }
        }

        list.add(new Node(key, value));
    }
    
    public int get(int key) {
        LinkedList<Node> list = map[key % map.length];
        for (Node n : list) {
            if (n.key == key) {
                return n.val;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        LinkedList<Node> list = map[key % map.length];
        for (Node n : list) {
            if (n.key == key) {
                list.remove(n);
                return;
            }
        }
    }
}

class Node {
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return String.format("{%d, %d}", key, val);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */