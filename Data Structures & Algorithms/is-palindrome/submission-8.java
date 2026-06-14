class Solution {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i < s.length() && j >= 0;) {
            if (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                i++;
                continue;
            } else if (!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j))) {
                j--;
                continue;
            } else if (!s.substring(i, i+1).equalsIgnoreCase(s.substring(j, j+1))) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}
