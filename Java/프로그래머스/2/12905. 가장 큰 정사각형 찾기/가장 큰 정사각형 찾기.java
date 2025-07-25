import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234;
        int max = 0;
        int[][] dp = new int[board.length][board[0].length];
        for(int i = 0; i < board[0].length; i++){
            dp[0][i] = board[0][i];
            max = Math.max(max, dp[0][i]);
        }
        for(int i = 0; i < board.length; i++){
            dp[i][0] = board[i][0];
            max = Math.max(max, dp[i][0]);
        }
        
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j < board[i].length; j++){
                if(board[i][j] == 1){
                   dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                   max = Math.max(dp[i][j], max);  
                }
               
            }
        }
        answer = max * max;

        return answer;
    }
}