import java.util.*;

class Solution {

    int base = 19;
    long mod = 1000000007;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long[] power = new long[n + 1];
        power[0] = 1;

        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * base) % mod;
        }

        int low = 1, high = n;
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(nums, mid, power)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int len,
                          long[] power) {

        int n = nums.length;

        HashMap<Long, Integer> map = new HashMap<>();

        long hash = 0;

        for (int i = 0; i < len; i++) {
            hash = (hash * base + nums[i]) % mod;
        }

        map.put(hash, 1);

        for (int i = len; i < n; i++) {

            hash = (hash - (power[len - 1] *
                    nums[i - len]) % mod + mod) % mod;

            hash = (hash * base + nums[i]) % mod;

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int freq : map.values()) {
            if (freq == 1) {
                return true;
            }
        }

        return false;
    }
}
