import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        Arrays.sort(nums, (a,b) -> Integer.parseInt(a) - Integer.parseInt(b));
        answer = nums[0] + " " + nums[nums.length - 1];
        return answer;
    }
}