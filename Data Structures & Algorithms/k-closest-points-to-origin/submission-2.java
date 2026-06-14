class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> q = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] point : points) {
            double x = point[0];
            double y = point[1];

            double dist = Math.sqrt((x*x) + (y*y));
            q.offer(new double[]{dist, x, y});
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            double[] point = q.poll();
            res[i] = new int[]{(int) point[1], (int) point[2]};
        }

        return res;
    }
}