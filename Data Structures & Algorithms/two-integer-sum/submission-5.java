class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> needToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (needToIndex.containsKey(nums[i]) && needToIndex.get(nums[i]) != i) return new int[]{needToIndex.get(nums[i]), i};
            needToIndex.put(target-nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
