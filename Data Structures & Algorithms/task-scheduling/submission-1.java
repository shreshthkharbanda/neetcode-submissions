class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pq.offer(e.getValue());
        }

        int time = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            if (pq.size() > 0) {
                int top = pq.poll();
                time++;
                if (top > 1) q.offer(new Pair(top-1, time+n));
            } else {
                time++;
            }

            while (q.size() > 0 && q.peek().getValue() == time) {
                Pair<Integer, Integer> pair = q.poll();
                pq.offer(pair.getKey());
            }
        }

        return time;
    }
}
