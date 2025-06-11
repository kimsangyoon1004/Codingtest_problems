import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int start = 0;
        List<Integer> list = new ArrayList<>();
        int listIndex = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);

            if (ch == 'S' || ch == 'D' || ch == 'T') {
                String numStr = dartResult.substring(start, i);
                int num = Integer.parseInt(numStr);
                int power = (ch == 'S') ? 1 : (ch == 'D') ? 2 : 3;

                list.add((int) Math.pow(num, power));
                listIndex++;
                start = i + 1;
            } else if (ch == '*') {
                if (listIndex == 0) {
                    list.set(listIndex, list.get(listIndex) * 2);
                } else {
                    list.set(listIndex - 1, list.get(listIndex - 1) * 2);
                    list.set(listIndex, list.get(listIndex) * 2);
                }
                start = i + 1;
            } else if (ch == '#') {
                list.set(listIndex, list.get(listIndex) * -1);
                start = i + 1;
            }
        }

        for (int score : list) {
            answer += score;
        }
        return answer;
    }
}
