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
        System.out.println(q);

        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i < k-1; i++) {
            int num = q.poll();
            System.out.println(num);
            vals.add(num);
        }

        int result = q.poll();
        System.out.println(result);

        for (int add : vals) {
            q.offer(add);
        }
        q.offer(result);

        return result;
    }
}
