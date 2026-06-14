class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> needToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            needToIndex.put(target-nums[i], i);
        }

        // {4, 0} {3, 1} {2, 2} {1, 3}

        for (int i = 0; i < nums.length; i++) {
            if (needToIndex.containsKey(nums[i]) && needToIndex.get(nums[i]) != i) return new int[]{i, needToIndex.get(nums[i])};
        }

        return new int[]{-1, -1};
    }
}
