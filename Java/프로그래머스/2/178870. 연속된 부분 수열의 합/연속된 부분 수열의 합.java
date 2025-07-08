// two pointer

import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        List<int[]> candidates = new ArrayList<>();
        
        int left = 0, right = 0;
        int sum = sequence[0];

        while (right < sequence.length) {
            if (sum == k) {
                candidates.add(new int[]{left, right});
                sum -= sequence[left];
                left++;
                if (left > right && left < sequence.length) {
                    right = left;
                    sum = sequence[right];
                }
            } else if (sum < k) {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else { 
                sum -= sequence[left];
                left++;
            }
        }

        candidates.sort((a, b) -> {
            int lenA = a[1] - a[0];
            int lenB = b[1] - b[0];
            if (lenA != lenB) return Integer.compare(lenA, lenB);
            return Integer.compare(a[0], b[0]);
        });

        return candidates.get(0);
    }
}
