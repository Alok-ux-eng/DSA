class Solution {

    public boolean check(List<StringBuilder> chessBoard , int row, int col) {

        int n = chessBoard.size();
        for (int i = 0; i < row; i++) {
            if (chessBoard.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        int i = row -1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (chessBoard.get(i).charAt(j) == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {
            if (chessBoard.get(i).charAt(j) == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public void solve(List<StringBuilder> chessBoard,  List<List<String>> ans,  int currRow, int n){
        if (currRow >= n) {
            List<String> tempBoard = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String row = chessBoard.get(i).toString();
                tempBoard.add(row);
            }
            ans.add(tempBoard);
            return;
        }
        for (int col = 0; col < n; col++) {

            if (check(chessBoard, currRow, col)) {
                chessBoard.get(currRow).setCharAt(col, 'Q');
                solve(chessBoard, ans, currRow + 1, n);
                chessBoard.get(currRow).setCharAt(col, '.');
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> chessBoard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            chessBoard.add(sb);
        }
        solve(chessBoard, ans, 0, n);
        return ans;
    }
}