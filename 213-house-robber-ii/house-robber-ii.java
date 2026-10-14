
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        // Case 1: Exclude the last house
        int case1 = robLinear(nums, 0, n - 2);

        // Case 2: Exclude the first house
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];

        dp[start] = nums[start];

        if (start + 1 <= end) {
            dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        }

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(
                dp[i - 2] + nums[i],
                dp[i - 1]
            );
        }

        return dp[end];
    }
}
