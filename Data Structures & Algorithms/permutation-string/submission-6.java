class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> freqs = new HashMap<>();
        for (char c : s1.toCharArray()) {
            freqs.put(c, freqs.getOrDefault(c, 0)+1);
        }

        int l = 0, r = 0;
        while (r < s1.length()-1) {
            char c = s2.charAt(r);
            freqs.put(c, freqs.getOrDefault(c, 0)-1);
            r++;
        }

        while (r < s2.length()) {
            char c = s2.charAt(r);
            // System.out.println(l + ", " + r + " (" + c + "), " + s2.substring(l, r+1) + ", " + freqs);
            if ((r-l) < s1.length() && freqs.getOrDefault(c, 0) > 0) {
                // System.out.println("case 1: " + l + ", " + r + " (" + c + "), " + s2.substring(l, r+1) + ", " + freqs);
                freqs.put(c, freqs.getOrDefault(c, 0)-1);
                if (areAllEntriesZero(freqs)) return true;
                r++;
            } else {
                // System.out.println("case 2: " + l + ", " + r + " (" + c + "), " + s2.substring(l, r+1) + ", " + freqs);
                freqs.put(s2.charAt(l), freqs.getOrDefault(s2.charAt(l), 0)+1);
                l++;
            }
            // System.out.println(l + ", " + r + " (" + c + "), " + freqs);
            // System.out.println();
        }

        return false;
    }
    private boolean areAllEntriesZero(Map<Character, Integer> freqs) {
        for (Map.Entry<Character, Integer> e : freqs.entrySet()) {
            if (e.getValue() != 0) return false;
        }
        return true;
    }
}
