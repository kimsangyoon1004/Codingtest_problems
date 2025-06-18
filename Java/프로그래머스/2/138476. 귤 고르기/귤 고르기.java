import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        List<Integer> amount = new ArrayList<>(map.values());
        amount.sort(Collections.reverseOrder());
        int sum = 0;
        for(int n : amount){
            sum += n;
            answer++;
            if(sum >= k){
                break;
            }
        }
        
        return answer;
    }
    
}