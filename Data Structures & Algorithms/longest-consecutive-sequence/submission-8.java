class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> all = new HashSet<>();
        Set<Integer> starts = new HashSet<>();
        for (int num : nums) all.add(num);

        
        for (int num : nums) {
            if (!all.contains(num-1)) starts.add(num);
        }

        int maxLen = 0;
        for (int start : starts) {
            int cur = start;
            while (all.contains(cur)) {
                cur++;
            }

            maxLen = Math.max(maxLen, cur-start);
        }


        return maxLen;
    }

    private boolean isStart(Map<Integer, Boolean> map, int num) {
        if (map.containsKey(num-1)) return false;
        return true;
    }
}
