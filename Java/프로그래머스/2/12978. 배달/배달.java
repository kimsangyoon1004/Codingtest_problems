import java.util.*;

class Solution {
    Set<Integer> reachable = new HashSet<>();
    List<List<int[]>> graph;
    boolean[] visited;

    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] r : road) {
            int a = r[0], b = r[1], cost = r[2];
            graph.get(a).add(new int[]{b, cost});
            graph.get(b).add(new int[]{a, cost});
        }

        visited = new boolean[N + 1];
        dfs(1, 0, K);
        return reachable.size();
    }

    void dfs(int node, int accTime, int K) {
        if (accTime > K) return;

        visited[node] = true;
        reachable.add(node);

        for (int[] next : graph.get(node)) {
            int nextNode = next[0];
            int cost = next[1];
            if (!visited[nextNode]) {
                dfs(nextNode, accTime + cost, K);
                visited[nextNode] = false; 
            }
        }
    }
}
