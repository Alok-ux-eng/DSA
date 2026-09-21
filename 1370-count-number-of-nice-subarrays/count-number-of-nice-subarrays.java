class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       return count(nums,k)-count(nums,k-1);
    }
    int count(int[] nums , int k){
        int l=0;
        int count=0;
        int r=0;
        int sum=0;
        while(r<nums.length){
            sum+=nums[r]%2;
            while(sum>k){
                sum-=nums[l]%2;
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}