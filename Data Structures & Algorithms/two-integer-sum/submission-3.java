class Solution {
    public int[] twoSum(int[] nums, int target) {
        // val, ix
        Map<Integer, List<Integer>> vals = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (vals.containsKey(num)) {
                vals.get(num).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                vals.put(num, indices);
            }
        }

        for (Map.Entry<Integer, List<Integer>> e : vals.entrySet()) {
            int val1 = e.getKey();
            if (vals.containsKey(target-val1)) {
                List<Integer> list2 = vals.get(target-val1);
                for (int ix : list2) {
                    if (ix != e.getValue().get(0)) {
                        if (ix < e.getValue().get(0)) {
                            return new int[]{ix, e.getValue().get(0)};
                        } else {
                            return new int[]{e.getValue().get(0), ix};
                        }
                    }
                }
            }
        }

        return new int[]{-1, -1};
    }
}
