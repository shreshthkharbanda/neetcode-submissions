class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0;
        int end = s.length()-1;

        while (start < end) {
            while (start < s.length() && !((s.charAt(start) >= 'a' && s.charAt(start) <= 'z') || (s.charAt(start) >= '0' && s.charAt(start) <= '9'))) {
                start++;
            }
            if (start >= s.length() || start > end) break;
            char letter1 = s.charAt(start);

            while (end > 0 && !((s.charAt(end) >= 'a' && s.charAt(end) <= 'z') || (s.charAt(end) >= '0' && s.charAt(end) <= '9'))) {
                end--;
            }
            if (end < 0 || start > end) return true;
            char letter2 = s.charAt(end);

            if (letter1 != letter2) return false;
            start++;
            end--;
        }

        return true;
    }
}
