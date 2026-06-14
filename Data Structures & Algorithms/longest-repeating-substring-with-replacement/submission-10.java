class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqs = new int[26];

        int start = 0;
        int end = 0;
        int maxFreq = 0;
        int maxLen = 0;

        while (start < s.length() && end < s.length()) {
            char cur = s.charAt(end);
            freqs[cur - 'A']++;
            for (int freq : freqs) {
                maxFreq = Math.max(maxFreq, freq);
            }
            int len = end - start + 1;
            int kVal = len - maxFreq;
            
            while (kVal > k) {
                freqs[s.charAt(start) - 'A']--;
                start++;

                for (int freq : freqs) {
                    maxFreq = Math.max(maxFreq, freq);
                }
                len = end - start + 1;
                kVal = len - maxFreq;
            }

            maxLen = Math.max(len, maxLen);
            end++;
        }

        return maxLen;
    }
}
