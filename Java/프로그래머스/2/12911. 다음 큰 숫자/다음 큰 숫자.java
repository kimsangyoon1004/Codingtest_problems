import java.util.*;
class Solution {
    public int solution(int n) {
        String binary = String.valueOf(Integer.toBinaryString(n));
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        int number = n + 1;
        while(true){
            if(binaryString(number) == count){
                break;
            }
            number++;
        }
        return number;
    }
    
    static int binaryString(int number){
        String binary = Integer.toBinaryString(number);
        int count = 0;
         for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}