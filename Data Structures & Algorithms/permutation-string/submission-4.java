class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> freqs1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            freqs1.put(c, freqs1.getOrDefault(c, 0)+1);
        }
        
        for (int l = 0, r = 0; r < s2.length();) {
            char c = s2.charAt(r);
            if (freqs1.getOrDefault(c, 0) > 0) {
                freqs1.put(c, freqs1.getOrDefault(c, 0)-1);
                if (areAllEntriesZero(freqs1)) return true;
                r++;
            } else {
                freqs1.put(s2.charAt(l), freqs1.getOrDefault(s2.charAt(l), 0)+1);
                l++;
            }
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
