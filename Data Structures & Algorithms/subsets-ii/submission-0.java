class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Map<Integer, Integer>> res = new ArrayList<>();
        Map<Integer, Integer> cur = new HashMap<>();

        dfs(nums, 0, cur, res);

        List<List<Integer>> solution = new ArrayList<>();

        for (Map<Integer, Integer> map : res) {
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                for (int i = 0; i < e.getValue(); i++) {
                    list.add(e.getKey());
                }
            }
            solution.add(list);
        }

        return solution;
    }

    private void dfs(int[] nums, int i, Map<Integer, Integer> cur, List<Map<Integer, Integer>> res) {
        if (i >= nums.length) {
            if (!res.contains(cur)) res.add(new HashMap<>(cur));
            return;
        }

        cur.put(nums[i], cur.getOrDefault(nums[i], 0)+1);
        dfs(nums, i+1, cur, res);
        cur.put(nums[i], cur.getOrDefault(nums[i], 1)-1);
        if (cur.get(nums[i]) <= 0) cur.remove(nums[i]);
        dfs(nums, i+1, cur, res);
    }
}
