class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0)+1);
        }

        Map<Integer, Set<Integer>> sorted = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> freq : freqs.entrySet()) {
            if (sorted.containsKey(freq.getValue())) {
                sorted.get(freq.getValue()).add(freq.getKey());
            } else {
                Set<Integer> ixs = new HashSet<>();
                ixs.add(freq.getKey());
                sorted.put(freq.getValue(), ixs);
            }
        }

        int[] topK = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Set<Integer>> sort : sorted.entrySet()) {
            if (i >= k) {
                break;
            }
            for (int num : sort.getValue()) {
                topK[i] = num;
                i++;
            }
        }

        return topK;
    }
}
