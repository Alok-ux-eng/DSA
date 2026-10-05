class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        int sumA = 0;
        int sumB = 0;
        for(int i = 0;i<aliceSizes.length;i++){
            sumA+=aliceSizes[i];
        }
        for(int j=0;j<bobSizes.length;j++){
            sumB+=bobSizes[j];
        }
        for(int i = 0;i<aliceSizes.length ; i++){
            for(int j=0;j<bobSizes.length;j++){
        int a= aliceSizes[i];
        int b = bobSizes[j];
        if(sumA-a+b == sumB-b+a){
            return new int[]{a,b};
        }
            }
        }
        return new int[]{-1,-1};
    }
}