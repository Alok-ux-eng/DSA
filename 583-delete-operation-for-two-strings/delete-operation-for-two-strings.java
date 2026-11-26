class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j]= 1+dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        int ans = dp[0][0];
        int deletion1 = n-ans;
        int deletion2  = m-ans;
        return deletion1 + deletion2;
    }
}