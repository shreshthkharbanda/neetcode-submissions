class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Set<Character> current = new HashSet<>();
        current.add(s.charAt(0));
        int longest = 0;
        for (int l = 0, r = 1; l < s.length()-1 && r < s.length(); r++) {
            while (current.contains(s.charAt(r))) {
                current.remove(s.charAt(l));
                l++;
            }
            current.add(s.charAt(r));
            longest = Math.max(longest, current.size());
        }

        return Math.max(longest, current.size());
    }
}
