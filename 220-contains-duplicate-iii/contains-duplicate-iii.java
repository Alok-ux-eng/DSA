import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            long curr = nums[i];

            Long num = set.ceiling(curr - valueDiff);

            if (num != null && num <= curr + valueDiff) {
                return true;
            }

            set.add(curr);

            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}