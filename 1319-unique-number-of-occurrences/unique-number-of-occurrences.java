class Solution {
    public boolean uniqueOccurrences(int[] arr) {
       HashMap<Integer, Integer> freq = new HashMap<>();
        
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>(freq.values());

        return set.size() == freq.size();
    }
}