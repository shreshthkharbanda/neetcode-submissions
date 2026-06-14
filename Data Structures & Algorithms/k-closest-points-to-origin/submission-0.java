class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Double> q = new PriorityQueue<>();
        Map<Double, List<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            double dist = Math.sqrt((x*x) + (y*y));
            q.offer(dist);
            if (map.containsKey(dist)) {
                map.get(dist).add(new Pair(x, y));
            } else {
                List<Pair<Integer, Integer>> list = new ArrayList<>();
                list.add(new Pair(x, y));
                map.put(dist, list);
            }
        }


        System.out.println(map);

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            double dist = q.poll();
            List<Pair<Integer, Integer>> pairs = map.get(dist);
            Pair<Integer, Integer> point = pairs.get(0);
            pairs.remove(0);
            res[i] = new int[]{point.getKey(), point.getValue()};            
        }

        return res;
    }
}
