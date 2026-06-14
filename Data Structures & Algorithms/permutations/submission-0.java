class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, cur, res);

        return res;
    }

    private void dfs(int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            dfs(nums, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
