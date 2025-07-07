import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = ""; 
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, (a,b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for(String n : nums){
            sb.append(n);
        }
        if (nums[0].equals("0")){
            return "0";
        }
        return sb.toString();
    }
}