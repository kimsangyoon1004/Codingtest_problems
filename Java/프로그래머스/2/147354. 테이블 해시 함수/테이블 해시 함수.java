import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        List<int[]> list = new ArrayList<>();
        for (int[] row : data) {
            list.add(row);
        }
        
        list.sort((a,b) ->{
             if (a[col - 1] != b[col - 1]) {
                return Integer.compare(a[col - 1], b[col - 1]);
            } else {
                return Integer.compare(b[0], a[0]); 
            }
        });
         for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int sum = 0;
            for (int val : list.get(i)) {
                sum += val % (i + 1);
            }
            answer ^= sum;
        }
        return answer;
    }
}