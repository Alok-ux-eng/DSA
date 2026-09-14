class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        //HashSet<Integer ,Integer> hs = new HashSet<>();
        int l =0;
        int r = 0;
        int ans =0;
        int maxLen = 0;
        HashSet<Integer> set = new HashSet<>();
        while(r<nums.length){
            ans+=nums[r];
           
            while(set.contains(nums[r])){
            ans-=nums[l];
            set.remove(nums[l]);
            l++;

        }
        set.add(nums[r]);
        maxLen = Math.max(maxLen,ans);
        r++;

        
    }
    return maxLen;
}
}
