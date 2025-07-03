import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);  

        Stack<Integer> stack = new Stack<>(); 

        for (int i = 0; i < n; i++) {
            
            while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = numbers[i];
            }
            stack.push(i);  
        }

        return answer;
    }
}
