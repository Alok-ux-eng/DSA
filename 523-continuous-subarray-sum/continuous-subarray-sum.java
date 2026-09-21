class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);

        int right =0;
        int sum = 0;
        while(right < nums.length) {
        sum+=nums[right];
        int ans = sum%k;
        if(map.containsKey(ans)) {
            if(right-map.get(ans)>1){
                return true;
            }
        }
        else{
            map.put(ans,right);
        }
        right++;
        }
        return false;
        
    }
}