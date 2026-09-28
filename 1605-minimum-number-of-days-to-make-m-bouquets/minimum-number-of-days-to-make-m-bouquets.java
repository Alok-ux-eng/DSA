class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;
        int max = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] > max) {
                max = bloomDay[i];
            }
        }
        int low = 1;
        int high = max;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int bouquets = 0;
            int flowers = 0;
            for (int j = 0; j < bloomDay.length; j++) {
                if (bloomDay[j] <= mid) {
                    flowers++;
                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }
            if (bouquets >= m) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}