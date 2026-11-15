import java.util.Arrays;

class Solution {
    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        long windowSize = 2L * k + 1;
        long sum = 0;

        int left = 0;

        for (int right = 0; right < n; right++) {

            
            sum += nums[right];

            
            if (right - left + 1 > windowSize) {
                sum -= nums[left];
                left++;
            }

            if (right - left + 1 == windowSize) {

                int center = left + k;

                ans[center] = (int)(sum / windowSize);
            }
        }

        return ans;
    }
}
