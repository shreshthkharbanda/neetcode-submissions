class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> ocurs = new HashMap<>();

        for (int num : nums) {
            ocurs.put(num, ocurs.getOrDefault(num, 0)+1);
        }

        final List<Integer>[] list = new ArrayList[nums.length+1];
        for (Map.Entry<Integer, Integer> ocur : ocurs.entrySet()) {
            final int freq = ocur.getValue();
            if (list[freq] == null) {
                list[freq] = new ArrayList<>();
            }
            list[freq].add(ocur.getKey());
        }

        int[] nums2 = new int[k];
        int x = 0;
        for (int i = list.length - 1; i >= 0 && x < k; i--) {
            if (list[i] == null) continue;
            for (int j = 0; j < list[i].size() && x < k; j++) {
                nums2[x] = list[i].get(j);
                x++;
            }
        }

        return nums2;
    }
}
