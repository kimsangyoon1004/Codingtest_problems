import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.offer(s);
        }

        int mixCount = 0;

        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();         
            int second = pq.poll();         
            int mixed = first + second * 2;

            pq.offer(mixed);
            mixCount++;
        }

        return pq.peek() >= K ? mixCount : -1;
    }
}
