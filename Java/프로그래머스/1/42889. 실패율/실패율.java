import java.util.*;
// 1. map   stagemap, failmap
// 2. sort
class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> stageMap = new HashMap<>();
        Map<Integer, Double> failureMap = new HashMap<>();

        
        for (int s : stages) {
            stageMap.put(s, stageMap.getOrDefault(s, 0) + 1);
        }

        int totalPlayers = stages.length;

        
        for (int i = 1; i <= N; i++) {
            int failed = stageMap.getOrDefault(i, 0);
            double failureRate = 0.0;
            if (totalPlayers > 0) {
                failureRate = (double) failed / totalPlayers;
            }
            failureMap.put(i, failureRate);
            totalPlayers -= failed; 
        }

       
        List<Integer> stageNumbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            stageNumbers.add(i);
        }

        stageNumbers.sort((a, b) -> {
            double diff = failureMap.get(b) - failureMap.get(a);
            if (diff == 0) {
                return Integer.compare(a, b); 
            }
            return Double.compare(failureMap.get(b), failureMap.get(a)); 
        });

        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageNumbers.get(i);
        }

        return answer;
    }
}
