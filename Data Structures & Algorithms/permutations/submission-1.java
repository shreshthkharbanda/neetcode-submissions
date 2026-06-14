class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        permute(nums, cur, res);

        return res;
    }

    public void permute(int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            if (!res.contains(cur)) res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;

            cur.add(nums[i]);
            permute(nums, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
