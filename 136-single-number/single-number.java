class Solution {
    public int singleNumber(int[] nums) {

       HashMap<Integer,Integer> mp = new HashMap<>();

     //  int nums = curr;
//To find Frequency (How many times Appears)
       for(int num : nums) {
        mp.put(num,mp.getOrDefault(num,0)+1);
       }

       //Check Exactly one 
       for(Map.Entry<Integer,Integer> entry : mp.entrySet()) {

        if(entry.getValue() == 1){
            return entry.getKey();
        }
       }

       return -1;

        
    }
}