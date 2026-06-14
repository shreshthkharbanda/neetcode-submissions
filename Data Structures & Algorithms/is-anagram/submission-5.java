class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sOcurs = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sOcurs[s.charAt(i) % 26]++;
            sOcurs[t.charAt(i) % 26]--;
        }

        for (int ocur : sOcurs) {
            if (ocur != 0) return false;
        }

        return true;
    }
}
