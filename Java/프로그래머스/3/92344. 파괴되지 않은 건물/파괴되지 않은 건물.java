class Solution {
    // Type = 1 -> attack, 2 -> recover
    // 6
    // 15
    // 24
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n + 1][m + 1];
        for(int i = 0; i < skill.length; i++){
            int type = skill[i][0];
            int startX = skill[i][1];
            int startY = skill[i][2];
            int endX = skill[i][3];
            int endY = skill[i][4];
            int degree = type == 1 ? -skill[i][5] : skill[i][5];
            diff[startX][startY] += degree;
            diff[startX][endY + 1] -= degree;
            diff[endX + 1][startY] -= degree;
            diff[endX + 1][endY + 1] += degree;
        }
        // 가로 누적합
       for(int i = 0; i < n + 1; i++){
           for(int j = 1; j < m + 1; j++){
               diff[i][j] += diff[i][j - 1];
           }
       }
        // 세로 누적합
       for(int i = 0; i < m + 1; i++){
           for(int j = 1; j < n + 1; j++){
               diff[j][i] += diff[j - 1][i];
           }
       }
       int count = 0;
       for(int i = 0; i < n; i++){
           for(int j = 0; j < m; j++){
               board[i][j] += diff[i][j];
               if(board[i][j] > 0){
                   count++;
               }
           }
       }
        
        return count;
    }
}