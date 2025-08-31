import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(!st.isEmpty() && st.peek() == c){
                st.pop();
                continue;
            }
            st.push(c);
        }
        answer = st.isEmpty() ? 1 : 0;
        return answer;
    }
}