class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int k = l;
        int min = Integer.MAX_VALUE;
        while(k<=r){
        int s =0;
        int e = 0;
        int sum =0;

        while(e<nums.size()){
            sum+=nums.get(e);
            while(e-s+1>k){
                sum-=nums.get(s);
                s++;
            }
            if(e-s+1 == k && sum > 0){
                min = Math.min(min,sum);
            }
            e++;
        }
        k++;
        }
        if(min == Integer.MAX_VALUE ) return  -1;
        return min;
    }
}