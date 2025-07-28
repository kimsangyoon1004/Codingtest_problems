import java.util.*;

class Edge {
    int to, cost;
    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Edge>> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            nodes.get(a).add(new Edge(b, 1));
            nodes.get(b).add(new Edge(a, 1));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        bfs(destination, dist, nodes);

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        return answer;
    }

    static void bfs(int start, int[] dist, List<List<Edge>> nodes) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Edge next : nodes.get(current)) {
                if (dist[next.to] == -1) {
                    dist[next.to] = dist[current] + 1;
                    queue.offer(next.to);
                }
            }
        }
    }
}
