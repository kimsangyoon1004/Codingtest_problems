import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        String baseString = toBase(n, t * m); 

        for (int i = p - 1; i < baseString.length(); i += m) {
            if (answer.length() == t) break;
            answer.append(baseString.charAt(i));
        }

        return answer.toString();
    }

    static String toBase(int n, int totalLength) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.length() < totalLength) {
            sb.append(Integer.toString(i++, n).toUpperCase());
        }
        return sb.toString();
    }
}
