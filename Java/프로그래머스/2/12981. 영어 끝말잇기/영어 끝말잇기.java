import java.util.*;

class Solution {
    // set
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]); 

        for (int i = 1; i < words.length; i++) {
            
            String prev = words[i - 1];
            String curr = words[i];

            
            if (set.contains(curr) || prev.charAt(prev.length() - 1) != curr.charAt(0)) {
                int person = (i % n) + 1;
                int round = (i / n) + 1;
                return new int[]{person, round};
            }

            set.add(curr);
        }

       
        return new int[]{0, 0};
    }
}