class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Set<Integer> set = new TreeSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        System.out.println(set);

        Iterator<Integer> it = set.iterator();
        int prev = it.next();
        int cur = 1;
        int max = 1;
        while (it.hasNext()) {
            int num = it.next();
            System.out.println(num + ", " + prev + ", " + cur + ", " + max);
            if (num - prev == 1) {
                cur++;
                max = Math.max(cur, max);
            } else {
                cur = 1;
            }
            prev = num;
        }

        return max;
    }
}
