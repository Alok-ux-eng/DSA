import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();

     for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            mp.put(curr, mp.getOrDefault(curr, 0) + 1);

            if (mp.get(curr) > 1) {
                return true;
            }
        }
        return false;
    }
}