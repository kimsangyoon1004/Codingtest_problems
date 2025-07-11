import java.util.*;

class Solution {
    List<int[]> result = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        // 리스트를 2차원 배열로 변환
        return result.toArray(new int[result.size()][]);
    }

    void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            result.add(new int[]{from, to});
            return;
        }
        hanoi(n - 1, from, via, to);   
        result.add(new int[]{from, to}); 
        hanoi(n - 1, via, to, from);   
    }
}
