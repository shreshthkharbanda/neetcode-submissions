class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> freqs1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            freqs1.put(c, freqs1.getOrDefault(c, 0)+1);
        }
        
        Map<Character, Integer> freqs1Copy = new HashMap<>(freqs1);
        for (int l = 0, r = 0; r < s2.length();) {
            // System.out.println(l + ", " + r + ", " + freqs1Copy);
            char c = s2.charAt(r);
            if (freqs1Copy.getOrDefault(c, 0) > 0) {
                freqs1Copy.put(c, freqs1Copy.get(c)-1);
                if (freqs1Copy.get(c) == 0) freqs1Copy.remove(c);
                if (freqs1Copy.entrySet().size() == 0) return true;
                r++;
            } else {
                l++;
                r = l;
                freqs1Copy = new HashMap<>(freqs1);
            }
            // System.out.println(l + ", " + r + ", " + freqs1Copy);
            // System.out.println();
        }

        return false;
    }
}
