class Solution {
    public double myPow(double x , int n) {
        long N=n;
        if(N==0){
            return 1;
        }
        if(N>0){
            return Math.pow(x,n);
        }
        else if(N<0){
            return 1/Math.pow(x,-N);

        }
        else
        return 0;
    }
}