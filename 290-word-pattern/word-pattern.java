class Solution {
    public boolean wordPattern(String pattern, String s) {
       
       // converrt intoo array 
        String[] arr = s.split(" ");

        if (pattern.length() != arr.length) {
            return false;
        }

        HashMap<Character, String> hm = new HashMap<>();
        HashMap<String, Character> reverse = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
              

              // iterate each character 
            char ch = pattern.charAt(i);
            String word = arr[i];

            // character already exists
            if (hm.containsKey(ch)) {

                if (!hm.get(ch).equals(word)) {
                    return false;
                }

            } else {

                // word is already mapped to another character
                if (reverse.containsKey(word)) {
                    return false;
                }

                hm.put(ch, word);
                reverse.put(word, ch);
            }
        }

        return true;
    }
}