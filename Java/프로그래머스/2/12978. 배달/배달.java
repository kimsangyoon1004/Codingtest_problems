import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 인접 리스트로 그래프 생성 (마을 번호 1부터 N까지)
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {  // 0번 인덱스는 사용 안함
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int time = r[2];
            graph.get(a).add(new int[]{b, time});
            graph.get(b).add(new int[]{a, time});
        }

        // 최단 거리 배열 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;  // 1번 마을 출발

        // 우선순위 큐 사용 (시간이 짧은 순서대로 방문)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0}); // {마을, 거리}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int time = cur[1];

            if (dist[node] < time) continue;  // 이미 더 짧은 경로 있음

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int nextTime = time + next[1];

                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    pq.add(new int[]{nextNode, nextTime});
                }
            }
        }

        // K 이하 거리인 마을 개수 세기
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
}
