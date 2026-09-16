class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int r =0;
        int count = 0;
        int  maxfruits =0;

        HashMap<Integer,Integer>mp = new HashMap<>();
        while( r < fruits.length) {

            mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);

            while(mp.size() > 2) {
                mp.put(fruits[l] ,mp.get(fruits[l])-1);

                if(mp.get(fruits[l])==0) {
                    mp.remove(fruits[l]);
                }
                l++;
            }

            maxfruits = Math.max(maxfruits, r-l+1);

            r++;
        }

        return maxfruits;
            
        
    }
}