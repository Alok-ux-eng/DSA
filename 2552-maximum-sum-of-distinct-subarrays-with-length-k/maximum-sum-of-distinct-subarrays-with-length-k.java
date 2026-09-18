class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        long ans = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            map.put(nums[right],
                    map.getOrDefault(nums[right], 0) + 1);

            // If window size becomes greater than k
            if (right - left + 1 > k) {

                int count = map.get(nums[left]);

                if (count == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], count - 1);
                }

                sum -= nums[left];
                left++;
            }

            // Check k distinct elements
            if (right - left + 1 == k && map.size() == k) {
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}