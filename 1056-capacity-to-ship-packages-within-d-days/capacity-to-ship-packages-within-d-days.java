class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;

        for (int w : weights) {
            l = Math.max(l, w); 
            r += w;             
        }

        while (l < r) {
            int mid = l + (r - l) / 2;

            int sum = 0;
            int count = 1;

            for (int w : weights) {
                if (sum + w > mid) {
                    count++;
                    sum = 0;
                }
                sum += w;
            }

            if (count <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}