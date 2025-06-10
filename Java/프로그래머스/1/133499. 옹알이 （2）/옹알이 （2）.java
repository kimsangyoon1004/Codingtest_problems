//practice dfs
import java.util.*;
class Solution {
    static String[] words = {"aya", "ye", "woo", "ma"};
    static int count;
    public int solution(String[] babbling) {
        int answer = 0;
        count = 0;
        for(String word : babbling){
            dfs(word, "");
        }
        return count;
    }
    
    static void dfs(String word, String prev){
        if(word.length() == 0){
            count++;
            return;
        }
        // 그 다음 조각이 그 전 조각이랑 다를떄 recurrsion 실행
        for(String say: words){
            if(word.startsWith(say) && !prev.equals(say)){
                dfs(word.substring(say.length()), say);
            }
        }
        
    }
}