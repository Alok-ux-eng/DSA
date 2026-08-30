class Solution {
    int ans = 0;
    public void solve(int[][] grid , int r , int c , int gold , boolean[][] vis){
        int m = grid.length;
        int n = grid[0].length;

        if(r>=m || c>=n || r<0 || c<0 || grid[r][c]==0 || vis[r][c]){
            ans= Math.max(ans,gold);
            return;
        }

        int curr = grid[r][c];

        vis[r][c] = true;

        solve(grid , r-1,c,gold+curr , vis);
        solve(grid , r+1,c,gold+curr , vis);
        solve(grid , r,c-1,gold+curr , vis);
        solve(grid , r,c+1,gold+curr , vis);

        vis[r][c] = false;
    }
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]!=0){
                    solve(grid , i,j,0,vis);
                }
            }
        }
        return ans;
    }
}