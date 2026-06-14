class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }
        
        for (int l = 0, r = s1.length()-1; r < s2.length();) {
            boolean isFullMatch = true;
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] != c2[i]) {
                    // System.out.println("inside: " + i + ", " + c1[i] + ", " + c2[i] + ", " + isFullMatch);
                    isFullMatch = false;
                } else if (c1[i] != 0 || c2[i] != 0) {
                    // System.out.println("inside: " + i + ", " + c1[i] + ", " + c2[i] + ", " + isFullMatch);
                }
            }

            // System.out.println(l + ", " + r + ", " + isFullMatch);

            if (isFullMatch) return true;

            c2[s2.charAt(l++) - 'a']--;
            if (r >= s2.length()-1) break;
            c2[s2.charAt(++r) - 'a']++;
        }

        return false;
    }
}
