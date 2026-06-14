class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        subsets(nums, 0, cur, res);

        return res;
    }

    public void subsets(int[] nums, int i, List<Integer> cur, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        subsets(nums, i+1, cur, res);
        cur.remove(cur.size()-1);
        subsets(nums, i+1, cur, res);
    }
}
