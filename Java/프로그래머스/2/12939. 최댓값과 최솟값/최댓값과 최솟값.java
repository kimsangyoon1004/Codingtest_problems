import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        int[] numArr= Arrays.stream(s.split(" "))
                            .mapToInt(Integer::parseInt)
                            .sorted()
                            .toArray();
        answer = String.valueOf(numArr[0]) + " " + String.valueOf(numArr[numArr.length - 1]);
        return answer;
    }
}