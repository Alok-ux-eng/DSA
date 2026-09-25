class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int x : map.keySet()) {
            if (map.get(x) > n / 3) {
                ans.add(x);
            }
        }

        return ans;
    }
}