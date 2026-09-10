class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int  l = 0;
        int r = 0;
        int sum = 0;
        int ans =0;
        while(r<arr.length){
            sum = sum + arr[r];
            r++;
            if(r-l>k){
                l++;
            }else if(r-l == k){
                if(sum/k >= threshold ) ans++;
                sum = sum - arr[l];
                l++;
            }
        }
        return ans;
    }
}