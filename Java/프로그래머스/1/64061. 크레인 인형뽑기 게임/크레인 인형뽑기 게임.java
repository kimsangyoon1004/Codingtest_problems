import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int picked = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 초기값으로 0을 넣는 방식도 괜찮긴 하나 없어도 됩니다.
        int row;

        for(int i = 0; i < moves.length; i++){
            row = 0;
            while(row < board.length){
                if(board[row][moves[i] - 1] != 0){
                    picked = board[row][moves[i] - 1];
                    board[row][moves[i] - 1] = 0;

                    if(stack.peek() == picked){
                        stack.pop();
                        answer += 2;  // ✅ 두 개 사라지니까 +2 해야 함
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
