import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (a, b) -> {
            return getMinutes(a[1]) - getMinutes(b[1]);
        });

        Stack<String[]> stack = new Stack<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < plans.length - 1; i++) {
            String name = plans[i][0];
            int startTime = getMinutes(plans[i][1]);
            int duration = Integer.parseInt(plans[i][2]);
            int endTime = startTime + duration;

            int nextStart = getMinutes(plans[i + 1][1]);

            if (endTime <= nextStart) {
                answer.add(name);
                int extraTime = nextStart - endTime;

                while (!stack.isEmpty() && extraTime > 0) {
                    String[] paused = stack.pop();
                    String pausedName = paused[0];
                    int leftTime = Integer.parseInt(paused[1]);

                    if (leftTime <= extraTime) {
                        answer.add(pausedName);
                        extraTime -= leftTime;
                    } else {
                        stack.push(new String[]{pausedName, String.valueOf(leftTime - extraTime)});
                        break;
                    }
                }

            } else {
                int remain = endTime - nextStart;
                stack.push(new String[]{name, String.valueOf(remain)});
            }
        }

        
        answer.add(plans[plans.length - 1][0]);
        while (!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }

        return answer.toArray(new String[0]);
    }

    private int getMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
