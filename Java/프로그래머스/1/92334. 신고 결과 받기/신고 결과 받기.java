
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        String[] elements = new String[2];
        String reporter;
        String reported;
        for(int i = 0; i < report.length; i++){
            elements = report[i].split(" ");
            reporter = elements[0];
            reported = elements[1];
            reportMap.putIfAbsent(reporter, new HashSet<>());
            // avoid repeating report
            if (reportMap.get(reporter).add(reported)) {
                countMap.put(reported, countMap.getOrDefault(reported, 0) + 1);
            }
        }

        for(int i = 0; i < id_list.length; i++){
            String user = id_list[i];
            Set<String> reportSet = reportMap.getOrDefault(user, new HashSet<>());
            for(String target : reportSet){
                if(countMap.get(target) >= k){
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}
