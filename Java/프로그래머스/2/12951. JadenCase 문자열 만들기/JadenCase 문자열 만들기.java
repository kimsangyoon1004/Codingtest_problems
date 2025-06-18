import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        if(s.charAt(0) - '0' >= 0 && s.charAt(0) - '0' <= 10){
            sb.append(String.valueOf(s.charAt(0)));
        }
        else{
            String firstLetter = String.valueOf(s.charAt(0)).toUpperCase();
            sb.append(firstLetter);
        }
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) == ' ' && s.charAt(i) != ' '){
                sb.append(String.valueOf(s.charAt(i)).toUpperCase());
            }
            else{
                sb.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
        }
        
      answer = sb.toString();
      return answer;
        
    }
}