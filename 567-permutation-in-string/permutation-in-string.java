class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int s = 0;
        int e = 0;

        while (e < s2.length()) {

            char right = s2.charAt(e);
            map2.put(right, map2.getOrDefault(right, 0) + 1);

            if (e - s + 1 > s1.length()) {

                char left = s2.charAt(s);

                map2.put(left, map2.get(left) - 1);

                if (map2.get(left) == 0) {
                    map2.remove(left);
                }

                s++;
            }
            if (e - s + 1 == s1.length()) {
                if (map1.equals(map2)) {
                    return true;
                }
            }

            e++;
        }

        return false;
    }
}