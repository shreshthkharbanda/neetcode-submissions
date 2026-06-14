class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> ocurs = new HashMap<>();

        for (int num : nums) {
            ocurs.put(num, ocurs.getOrDefault(num, 0)+1);
        }

        final Map<Integer, Set<Integer>> ocursToNum = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<Integer, Integer> ocur : ocurs.entrySet()) {
            if (ocursToNum.containsKey(ocur.getValue())) {
                ocursToNum.get(ocur.getValue()).add(ocur.getKey());
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(ocur.getKey());
                ocursToNum.put(ocur.getValue(), set);
            }
        }

        int[] nums2 = new int[k];
        int i = 0;
        for (int key : ocursToNum.keySet()) {
            for (int num : ocursToNum.get(key)) {
                if (i >= k) break;
                nums2[i] = num;
                i++;
            }
        }

        return nums2;
    }
}
