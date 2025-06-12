import java.util.*;

class Solution {
    // 1 = bread, 2 = vege, 3 = meat
    // 1 - 2 - 3 - 1
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int ing : ingredient) {
            stack.push(ing);
            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 1 &&
                    stack.get(size - 3) == 2 &&
                    stack.get(size - 2) == 3 &&
                    stack.get(size - 1) == 1) {
                    for (int i = 0; i < 4; i++) {
                        stack.pop();
                    }
                    answer++;
                }
            }
        }

        return answer;
    }
}

