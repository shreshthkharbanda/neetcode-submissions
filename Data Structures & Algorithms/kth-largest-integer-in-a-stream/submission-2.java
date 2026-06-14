class KthLargest {
    Queue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>(Collections.reverseOrder());
        this.k = k;

        for (int num : nums) {
            q.offer(num);
        }
    }
    
    public int add(int val) {
        q.offer(val);

        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i < k-1; i++) {
            int num = q.poll();
            vals.add(num);
        }

        int result = q.poll();

        for (int add : vals) {
            q.offer(add);
        }
        q.offer(result);

        return result;
    }
}
