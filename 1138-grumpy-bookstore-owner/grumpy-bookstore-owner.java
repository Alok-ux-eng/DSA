class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int satisfied = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }

        int left = 0;
        int sum = 0;
        int maxSum = 0;

        for (int right = 0; right < customers.length; right++) {

            if (grumpy[right] == 1) {
                sum += customers[right];
            }

            if (right - left + 1 > minutes) {

                if (grumpy[left] == 1) {
                    sum -= customers[left];
                }

                left++;
            }
            maxSum = Math.max(maxSum, sum);
        }

        return satisfied + maxSum;
    }
}
