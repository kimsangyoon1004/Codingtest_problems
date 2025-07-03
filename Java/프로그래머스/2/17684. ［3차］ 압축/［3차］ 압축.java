import java.util.*;
class Solution {
    
    public int[] solution(String msg) {
        int[] answer = {};
        Map<String, Integer> wordMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(char w = 'A'; w <= 'Z'; w++){
            wordMap.put(String.valueOf(w), w - 64);
        }
        int dictSize = 27;
        int idx = 0;
        
        while(idx < msg.length()){
            String w = "" + msg.charAt(idx);
            int next = idx + 1;
            
            while(next <= msg.length()){
                String temp = msg.substring(idx, next);
                if(wordMap.containsKey(temp)){
                    w = temp;
                    next++;
                }
                else{
                    break;
                }
            }
            
            list.add(wordMap.get(w));
            // put new word
            if(next <= msg.length()){
                wordMap.put(msg.substring(idx, next), dictSize++);
            }
            
            idx += w.length();
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}