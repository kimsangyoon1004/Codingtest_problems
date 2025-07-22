class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] queenMap = new int[n];
        answer = nQueen(queenMap, 0, n);
        return answer;
    }
    static int nQueen(int[] queenMap, int row, int n){
        if(row == n){
            return 1;
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(isVaild(queenMap, row, i)){
                queenMap[row] = i;
                count += nQueen(queenMap, row + 1, n);
            }
        }
        return count;
    }
    static boolean isVaild(int[] queenMap, int row, int col){
        for(int i = 0; i < row; i++){
            if(queenMap[i] == col || (Math.abs(i - row)) == (Math.abs(queenMap[i] - col))){
                return false;
            }
        }
        return true;
    }
}