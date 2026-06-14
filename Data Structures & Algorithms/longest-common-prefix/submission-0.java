class Solution {
    public String longestCommonPrefix(String[] strs) {
        String baseline = strs[0];
        if (strs.length < 1) return baseline;

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < Math.min(strs[i].length(), baseline.length()); j++) {
                if (strs[i].charAt(j) == baseline.charAt(j)) continue;
                else break;
            }
            baseline = baseline.substring(0, j);
        }

        return baseline;
    }
}