import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int lastEnd = -1;

        for (int[] t : targets) {
            if (t[0] >= lastEnd) {
                answer++;
                lastEnd = t[1];
            }
        }

        return answer;
    }
}