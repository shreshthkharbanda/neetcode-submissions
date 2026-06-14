class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        if (stones.length == 1) return stones[0];
        for (int stone : stones) {
            q.offer(stone);
        }

        while (q.size() > 1) {
            int max = q.poll();
            int min = q.poll();
            System.out.println(max + ", " + min);
            if (max != min) q.offer(max - min);
            System.out.println(q);
        }

        return q.size() > 0 ? q.poll() : 0;
    }
}