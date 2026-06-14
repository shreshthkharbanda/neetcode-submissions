class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        combinationSum(nums, target, 0, cur, res);

        return res;
    }

    public void combinationSum(int[] nums, int target, int i, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            if (!res.contains(cur)) res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || i >= nums.length) return;

        cur.add(nums[i]);
        combinationSum(nums, target - nums[i], i, cur, res);
        cur.remove(cur.size()-1);
        combinationSum(nums, target, i+1, cur, res);
    }
}
