import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> windowMap = new HashMap<>();   
            for (int j = i; j < i + 10; j++) {
                windowMap.put(discount[j], windowMap.getOrDefault(discount[j], 0) + 1);
            }    
            if (windowMap.equals(wantMap)) {
                answer++;
            }
        }

        return answer;
    }
}
