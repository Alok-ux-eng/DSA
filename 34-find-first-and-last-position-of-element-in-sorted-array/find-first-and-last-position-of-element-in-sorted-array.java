class Solution {

    public int[] searchRange(int[] nums, int target) {
        return new int[] {
            findFirst(nums, target, 0, nums.length - 1),
            findLast(nums, target, 0, nums.length - 1)
        };
    }

    static int findFirst(int[] nums, int target, int low, int high) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (nums[mid] == target) {
            int left = findFirst(nums, target, low, mid - 1);
            return left == -1 ? mid : left;
        }

        if (nums[mid] < target)
            return findFirst(nums, target, mid + 1, high);

        return findFirst(nums, target, low, mid - 1);
    }

    static int findLast(int[] nums, int target, int low, int high) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (nums[mid] == target) {
            int right = findLast(nums, target, mid + 1, high);
            return right == -1 ? mid : right;
        }

        if (nums[mid] < target)
            return findLast(nums, target, mid + 1, high);

        return findLast(nums, target, low, mid - 1);
    }
}