class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0;
        int r = 0;
        int ans = 0;
        int max = 0;

        int[] arr = new int[26];
        int n = s.length();

        while (r < n) {

            // Add current character
            arr[s.charAt(r) - 'A']++;

            // Maximum frequency in current window
            max = Math.max(max, arr[s.charAt(r) - 'A']);

            // Characters that need replacement
            int changes = (r - l + 1) - max;

            // Shrink window if more than k replacements are needed
            while (changes > k) {
                arr[s.charAt(l) - 'A']--;
                l++;

                changes = (r - l + 1) - max;
            }

            // Update answer
            ans = Math.max(ans, r - l + 1);

            r++;
        }

        return ans;
    }
}