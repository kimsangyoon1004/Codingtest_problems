import java.util.*;
class Solution {
    public int solution(String s) {
        // [], (), {} right condition
        // stack
        int answer = 0;
        int len = s.length();
        for(int i = 0; i < len; i++){
            Stack<Character> stack = new Stack<>();
            for(int j = i; j < len + i; j++){
               if(!stack.isEmpty() && isVaild(s.charAt(j % len), stack)){
                   stack.pop();
               }
                else{
                    stack.push(s.charAt(j % len));
                }
               
            }
            if(stack.size() == 0){
                answer++;
            }
        }
        return answer;
    }
    static boolean isVaild(char ch, Stack<Character> stack){
        if(ch == ']' && stack.peek() == '['){
            return true;
        }
        else if(ch == '}' && stack.peek() == '{'){
            return true;
        }
        else if(ch == ')' && stack.peek() == '('){
            return true;
        }
        return false;
    }
 }
