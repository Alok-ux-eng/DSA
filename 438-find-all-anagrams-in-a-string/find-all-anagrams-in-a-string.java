class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Frequency of characters in p
        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a']++;
        }

        int k = p.length();

        // First window
        for (int i = 0; i < k; i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(pFreq, windowFreq)) {
            result.add(0);
        }

        // Sliding Window
        for (int i = k; i < s.length(); i++) {

            // Add new character
            windowFreq[s.charAt(i) - 'a']++;

            // Remove old character
            windowFreq[s.charAt(i - k) - 'a']--;

            // Check anagram
            if (Arrays.equals(pFreq, windowFreq)) {
                result.add(i - k + 1);
            }
        }

        return result;
    }
}