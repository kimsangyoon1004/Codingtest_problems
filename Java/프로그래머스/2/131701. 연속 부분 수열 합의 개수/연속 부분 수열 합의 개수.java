import java.util.*;

class Solution {
    // Sliding Window, Set
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        int[] doubled = new int[n * 2];

        
        for (int i = 0; i < n * 2; i++) {
            doubled[i] = elements[i % n];
        }

        
        for (int len = 1; len <= n; len++) {
            int sum = 0;

            
            for (int i = 0; i < len; i++) {
                sum += doubled[i];
            }
            set.add(sum);

            
            for (int i = len; i < n + len - 1; i++) {
                sum = sum - doubled[i - len] + doubled[i];
                set.add(sum);
            }
        }

        return set.size();
    }
}
