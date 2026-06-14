class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqs = new int[26];

        int start = 0;
        int end = 0;
        int maxFreq = 0;
        int maxLen = 0;

        while (start < s.length() && end < s.length()) {
            maxFreq = Math.max(maxFreq, ++freqs[s.charAt(end) - 'A']);
            
            while (end - start + 1 - maxFreq > k) {
                maxFreq = Math.max(maxFreq, --freqs[s.charAt(start) - 'A']);
                start++;
            }

            maxLen = Math.max(end - start + 1, maxLen);
            end++;
        }

        return maxLen;
    }
}
