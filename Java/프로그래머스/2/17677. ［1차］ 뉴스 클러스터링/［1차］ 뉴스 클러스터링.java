import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        
       
        for (int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                str1List.add("" + a + b);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                str2List.add("" + a + b);
            }
        }

        
        List<String> tempStr2List = new ArrayList<>(str2List);
        int intersection = 0;

        for (String s : str1List) {
            if (tempStr2List.contains(s)) {
                intersection++;
                tempStr2List.remove(s);  
            }
        }

        int union = str1List.size() + str2List.size() - intersection;

        if (union == 0) {
            answer = 65536;
        } else {
            answer = (int) (((double) intersection / union) * 65536);
        }

        return answer;
    }
}
