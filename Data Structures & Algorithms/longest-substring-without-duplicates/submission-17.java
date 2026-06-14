class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        for (;start < s.length() && end < s.length();) {
            if (set.contains(s.charAt(end))) {
                maxLen = Math.max(end-start, maxLen);
                set.remove(s.charAt(start));
                start++;
            } else {
                set.add(s.charAt(end));
                end++;
            }
        }

        return Math.max(end-start, maxLen);
    }
}
