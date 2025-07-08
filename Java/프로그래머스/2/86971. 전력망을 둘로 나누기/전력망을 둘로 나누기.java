// Bfs
// Graph(nodes)
import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // add nodes
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        int min = Integer.MAX_VALUE;
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            boolean[] visited = new boolean[n + 1];
            int count = bfs(graph, a, b, visited);
            int remain = n - count;
            int diff = Math.abs(count - remain);
            min = Math.min(min, diff);
        }
        return min;
    }
    static int bfs(List<List<Integer>> graph, int start, int cut, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next : graph.get(current)){
                if((current == start && next == cut) || (current == next && next == start) ){
                    continue;
                }
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}