import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {

        if (k == 1) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            if (right - left + 1 == k) {

                int diff = nums[right] - nums[left];

                ans = Math.min(ans, diff);

                left++;
            }
        }

        return ans;
    }
}

