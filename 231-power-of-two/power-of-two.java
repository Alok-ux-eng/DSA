class Solution {
    public boolean isPowerOfTwo(int n) {

        //base case 

        if (n <= 0)
        return false;

        if (n == 1)
        return true;
        
        //conditions 

        if (n % 2 != 0)
        return false;

        //return value 

        return isPowerOfTwo(n/2);
    
        
    }
}