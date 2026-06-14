class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        dfs(nums, target, 0, 0, cur, res);

        return res;
    }

    public void dfs(int[] nums, int target, int i, int curSum, List<Integer> cur, List<List<Integer>> res) {
        if (i >= nums.length && curSum != target) return;
        if (curSum > target) return;
        if (curSum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        curSum += nums[i];
        dfs(nums, target, i, curSum, cur, res);
        cur.remove(cur.size()-1);
        curSum -= nums[i];
        dfs(nums, target, i+1, curSum, cur, res);
    }
}
