import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String firstWord = String.valueOf(s.charAt(0)).toUpperCase();           
        answer += firstWord;
        for(int i = 1; i < s.length(); i++){
           
            if(String.valueOf(s.charAt(i - 1)).equals(" ")){
                answer += String.valueOf(s.charAt(i)).toUpperCase();
            }
            else{
                answer += String.valueOf(s.charAt(i)).toLowerCase();
            }
               
        }
        return answer;
    }
}