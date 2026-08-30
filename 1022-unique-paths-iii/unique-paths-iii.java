class Solution {
    int rows, cols;
    int totalCells;
    int result = 0;

    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != -1) {
                    totalCells++;
                }

                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        dfs(grid, startRow, startCol, 1);

        return result;
    }

    private void dfs(int[][] grid, int row, int col, int count) {
        if (row < 0 || row >= rows || col < 0 || col >= cols
                || grid[row][col] == -1) {
            return;
                }
        if (grid[row][col] == 2) {
            if (count == totalCells) {
                result++;
            }
            return;
        }
        grid[row][col] = -1;
        dfs(grid, row + 1, col, count + 1);
        dfs(grid, row - 1, col, count + 1);
        dfs(grid, row, col + 1, count + 1);
        dfs(grid, row, col - 1, count + 1);
        grid[row][col] = 0;
    }
}