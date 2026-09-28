class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max =0;
        for (int i =0; i < piles.length; i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        int low =1;
        int high = max;
        while(low<high){
            int mid = (high+low) / 2;
            long sum = 0;
            for(int j = 0; j < piles.length; j++){
                sum += (piles[j] + mid - 1) / mid;
            
        }
        if(sum<=h){
            high=mid;

        }
        else{
            low=mid+1;
        }
        
    }
    return low;
    }
}