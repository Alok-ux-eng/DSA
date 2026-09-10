class Solution {

    public boolean isVowel(char curr) {
        if (curr == 'a' || curr == 'e' || curr == 'i' ||
            curr == 'o' || curr == 'u') {
            return true;
        }
        return false;
    }

    public int maxVowels(String s, int k) {

        int st = 0;
        int e = 0;
        int vowels = 0;
        int maxVowels = 0;

        while (e < s.length()) {

            char curr = s.charAt(e);

            if (isVowel(curr) == true) {
                vowels++;
            }

            int windowSize = e - st + 1;

            if (windowSize < k) {
                e++;
            }

            else if (windowSize == k) {

                maxVowels = Math.max(vowels, maxVowels);

                // Move right
                e++;

                // Remove left character
                if (isVowel(s.charAt(st)) == true) {
                    vowels--;
                }

                st++;
            }
        }

        return maxVowels;
    }
}