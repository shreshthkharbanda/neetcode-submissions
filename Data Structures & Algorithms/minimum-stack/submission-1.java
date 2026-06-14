class MinStack {
    Stack<Integer> stack;
    // num to freq
    TreeMap<Integer, Integer> map;

    public MinStack() {
        stack = new Stack<>();
        map = new TreeMap<>();
    }
    
    public void push(int val) {
        stack.push(val);
        map.put(val, map.getOrDefault(val, 0)+1);
    }
    
    public void pop() {
        int pop = stack.pop();
        int newVal = map.get(pop)-1;
        if (newVal == 0) {
            map.remove(pop);
        } else {
            map.put(pop, map.get(pop)-1);
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return map.firstKey();
    }
}
