class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Set<Character> current = new HashSet<>();
        current.add(s.charAt(0));
        int longest = 0;
        for (int l = 0, r = 1; l < s.length()-1 && r < s.length();) {
            if (!current.contains(s.charAt(r))) {
                current.add(s.charAt(r));
                r++;
            } else {
                longest = Math.max(longest, current.size());
                current.remove(s.charAt(l));
                l++;
                current.add(s.charAt(l));
            }

            if (r == l) {
                r++;
            }
        }

        return Math.max(longest, current.size());
    }
}
