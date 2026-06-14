class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        Arrays.sort(candidates);

        dfs(candidates, 0, target, cur, res);

        return res;
    }

    private void dfs(int[] candidates, int i, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            if (!res.contains(cur)) res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || i >= candidates.length) return;

        cur.add(candidates[i]);
        dfs(candidates, i+1, target-candidates[i], cur, res);
        cur.remove(cur.size()-1);
        dfs(candidates, i+1, target, cur, res);
    }
}
