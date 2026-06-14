class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqs = new HashMap<>();
        // int len = 0;
        int max = 0;

        freqs.put(s.charAt(0), 1);
        // s="AABABBA", k=1
        for (int l = 0, r = 0; r <= s.length();) {
            // System.out.println("(" + l + ", " + r + "), " + freqs + ", " + maxFreq(freqs) + ", " + k + ", " + max);
            if (((r-l)+1) - maxFreq(freqs) <= k) {
                // System.out.println("case 1: " + l + ", " + r + ", " + max);
                max = Math.max((r-l)+1, max);
                r++;
                if (r >= s.length()) break;
                freqs.put(s.charAt(r), freqs.getOrDefault(s.charAt(r), 0)+1);
            } else {
                // System.out.println("case 2: " + l + ", " + r + ", " + max);
                freqs.put(s.charAt(l), freqs.get(s.charAt(l))-1);
                l++;
            }
            // System.out.println("(" + l + ", " + r + "), " + freqs + ", " + maxFreq(freqs) + ", " + k + ", " + max);
            System.out.println();
        }

        return max;
    }

    private int maxFreq(Map<Character, Integer> freqs) {
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> e : freqs.entrySet()) {
            maxFreq = Math.max(maxFreq, e.getValue());
        }

        return maxFreq;
    } 
}
