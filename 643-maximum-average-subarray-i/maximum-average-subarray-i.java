class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int  s = 0; 
        int e = 0; 
        int sum = 0; 
        int maxSum = Integer.MIN_VALUE;

        while(e < nums.length) {
            sum+=nums[e];
            e++;

            if(e-s == k) {
                maxSum = Math.max(maxSum,sum);
              //  s++;
              sum -= nums[s];
                s++;
            
            }
        }
         return (double) maxSum / k;
    }
}