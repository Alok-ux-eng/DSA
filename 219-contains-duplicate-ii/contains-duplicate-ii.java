class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer ,Integer> mp = new HashMap<>();

        for(int i =0; i<nums.length; i++){
            int curr = nums[i];

            if(mp.containsKey(curr)==true){
                int prevOccIndex = mp.get(curr);
                if(Math.abs(prevOccIndex - i) <=k) return true;
                
            }
            mp.put(curr,i);
        }
        return false;
    }
}