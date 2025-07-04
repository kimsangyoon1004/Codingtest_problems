import java.util.*;

class Solution {
    public int solution(int[] order) {
        int n = order.length;
        Stack<Integer> stack = new Stack<>();
        int current = 1;
        int orderIdx = 0;
        int answer = 0;

        while (orderIdx < n) {
            if (!stack.isEmpty() && stack.peek() == order[orderIdx]) {
                stack.pop();
                orderIdx++;
                answer++;
            }
            
            else if (current <= n) {
                if (current == order[orderIdx]) {
                    orderIdx++;
                    answer++;
                } else {
                    stack.push(current);
                }
                current++;
            }
            
            else {
                break;
            }
        }

        return answer;
    }
}
