import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(!st.isEmpty() && c == ')' && st.peek() == '('){
                st.pop();
                continue;
            }
            st.push(c);
        }
       if(st.isEmpty()){
           answer = true;
       }
        else{
            answer = false;
        }

        return answer;
    }
}