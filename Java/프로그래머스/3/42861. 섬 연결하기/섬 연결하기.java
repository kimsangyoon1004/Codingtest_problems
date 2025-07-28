import java.util.*;

class Solution {
    static class Edge {
        int to, cost;
        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    public int solution(int n, int[][] costs) {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());

        for(int[] c : costs) {
            graph.get(c[0]).add(new Edge(c[1], c[2]));
            graph.get(c[1]).add(new Edge(c[0], c[2]));
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);

        int answer = 0;
        int count = 0;

        
        pq.offer(new Edge(0, 0));

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(visited[edge.to]) continue;

            visited[edge.to] = true;
            answer += edge.cost;
            count++;

            if(count == n) break;

            for(Edge next : graph.get(edge.to)) {
                if(!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }

        return answer;
    }
}
