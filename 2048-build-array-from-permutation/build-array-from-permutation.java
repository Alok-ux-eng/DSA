class Solution {
    public int[] buildArray(int[] nums) {
        int[] res=new int[nums.length];
        int newi;
        for(int i=0; i<nums.length; i++){
            newi=nums[i];
            res[i]=nums[newi];

        }
        return res;
    }
}