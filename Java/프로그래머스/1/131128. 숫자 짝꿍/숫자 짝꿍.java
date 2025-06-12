import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] freqY = new int[10];  
        for(int i = 0; i < Y.length(); i++){
            freqY[Y.charAt(i) - '0']++;
        }

        List<Character> pair = new ArrayList<>();

        for(int i = 0; i < X.length(); i++){
            int digit = X.charAt(i) - '0';
            if(freqY[digit] > 0){
                freqY[digit]--;
                pair.add(X.charAt(i));
            }
        }

        if(pair.isEmpty()) {
            return "-1";
        }

        pair.sort(Comparator.reverseOrder());

        int zeroCount = 0;
        StringBuilder answer = new StringBuilder();

        for(char c : pair){
            if(c == '0'){
                zeroCount++;
            }
            answer.append(c);
        }

        if(zeroCount == pair.size()){
            return "0";
        }

        return answer.toString();
    }
}
