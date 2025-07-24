import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int count = 0;
        Queue<String[]> queue = new LinkedList<>();
        queue.offer(new String[]{begin, "0"});
        boolean[] visited = new boolean[words.length];
        while(!queue.isEmpty()){
            String[] current = queue.poll();
            String word = current[0];
            count = Integer.parseInt(current[1]);
            if(word.equals(target)){
                return count;
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && isVaild(word, words[i])){
                    visited[i] = true;
                    queue.offer(new String[]{words[i], String.valueOf(count + 1)});
                }
            }
        }
        return 0;
    }
    static boolean isVaild(String before, String after){
        int diff = 0;
        for(int i = 0; i < before.length(); i++){
            if(before.charAt(i) != after.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
}