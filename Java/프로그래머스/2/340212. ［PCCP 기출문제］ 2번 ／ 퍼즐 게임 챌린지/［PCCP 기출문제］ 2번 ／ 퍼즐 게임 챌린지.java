import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 1000000;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (timeTook(diffs, times, mid, limit)) {
                answer = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    static boolean timeTook(int[] diffs, int[] times, int level, long limit) {
        long sum = 0;
        for (int i = 0; i < diffs.length; i++) {
            long currentTime = times[i];
            long diff = diffs[i];

            if (diff <= level) {
                sum += currentTime;
            } else {
                long beforeTime = times[i - 1]; 
                long repeat = diff - level;
                long currentTimeTook = (currentTime + beforeTime) * repeat + currentTime;
                sum += currentTimeTook;
            }

            if (sum > limit) return false;
        }
        return true;
    }
}
