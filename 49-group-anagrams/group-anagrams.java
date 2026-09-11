class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String , List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] freq = new int[26];

            for (char ch : str.toCharArray()) {
                freq[ch - 'a'] ++;
            }

            String Key = Arrays.toString(freq);

            map.putIfAbsent(Key,new ArrayList<>());
            map.get(Key).add(str);

        }

        return new ArrayList<>(map.values());
    }
}