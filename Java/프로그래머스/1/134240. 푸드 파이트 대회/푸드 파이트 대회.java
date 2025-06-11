import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder str1 = new StringBuilder();
        StringBuilder strfinal = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            int foodn = food[i];
            int eachfoodn = foodn / 2;
            String addfood = String.valueOf(eachfoodn);
            for(int j = 1; j <= eachfoodn; j++){
                str1.append(String.valueOf(i));
            }
        }
        strfinal.append(str1).append("0").append(str1.reverse());
        answer = strfinal.toString();
        return answer;
    }
}