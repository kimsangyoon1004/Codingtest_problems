import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
       
        Set<Character> exclude = new HashSet<>();
        for (char ch : skip.toCharArray()) {
            exclude.add(ch);
        }

        
        List<Character> validChars = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (!exclude.contains(c)) {
                validChars.add(c);
            }
        }

        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int pos = validChars.indexOf(ch);
            int newPos = (pos + index) % validChars.size(); // go to first alphabet if reaches end
            answer.append(validChars.get(newPos));
        }

        return answer.toString();
    }
}
