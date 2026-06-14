class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0, new ArrayList<>());
        return list;
    }

    private void subsets(int[] nums, int i, List<Integer> cur) {
        if (i >= nums.length) {
            if (!list.contains(cur)) {
                list.add(new ArrayList<>(cur));
            }
            return;
        }
        cur.add(nums[i]);
        subsets(nums, i+1, cur);
        cur.remove((Integer) nums[i]);
        subsets(nums, i+1, cur);
    }
}
