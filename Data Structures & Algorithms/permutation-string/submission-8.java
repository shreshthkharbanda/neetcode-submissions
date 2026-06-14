class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> freqs = new HashMap<>();
        for (char c : s1.toCharArray()) {
            freqs.put(c, freqs.getOrDefault(c, 0)+1);
        }

        int countZero = 0;
        int l = 0, r = 0;
        while (r < s2.length()) {
            char c = s2.charAt(r);
            if ((r-l) < s1.length()) {
                freqs.put(c, freqs.getOrDefault(c, 0)-1);
                if (freqs.get(c) == 0) countZero++;
                if (areAllEntriesZero(freqs)) return true;
                r++;
            } else {
                if (freqs.containsKey(s2.charAt(l)) && freqs.get(s2.charAt(l)) == 0) countZero--;
                freqs.put(s2.charAt(l), freqs.getOrDefault(s2.charAt(l), 0)+1);
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
