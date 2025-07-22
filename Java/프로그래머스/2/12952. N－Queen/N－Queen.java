class Solution {
    public int solution(int n) {
        return nQueen(new int[n], 0, n);
    }

   
    static int nQueen(int[] queenMap, int row, int n){
        if (row == n) return 1;

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (isSafe(queenMap, row, col)) {
                queenMap[row] = col;
                count += nQueen(queenMap, row + 1, n);
            }
        }
        return count;
    }

    static boolean isSafe(int[] queenMap, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queenMap[i] == col || 
                Math.abs(queenMap[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
