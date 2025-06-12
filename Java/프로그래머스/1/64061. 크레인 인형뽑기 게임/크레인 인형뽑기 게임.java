import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int picked = 0;
        Stack<Integer> stack = new Stack<>();
        int row;

        for(int i = 0; i < moves.length; i++){
            row = 0;
            while(row < board.length){
                if(board[row][moves[i] - 1] != 0){
                    picked = board[row][moves[i] - 1];
                    board[row][moves[i] - 1] = 0;

                    if(!stack.isEmpty() && stack.peek() == picked){
                        stack.pop();
                        answer += 2;  
                    } else {
                        stack.push(picked);
                    }
                    break;
                } else {
                    row++;
                }
            }
        }

        return answer;
    }
}
