import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer> longestNode = new ArrayList<>();
        List<List<Integer>> nodes = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for(int i = 0; i <= n; i++){
            nodes.add(new ArrayList<>());
        }
        for(int i = 0; i < edge.length; i++){
            nodes.get(edge[i][0]).add(edge[i][1]);
            nodes.get(edge[i][1]).add(edge[i][0]);
        }
        bfs(nodes, longestNode, visited, 1);
        int maxLength = Collections.max(longestNode);
        int count = Collections.frequency(longestNode, maxLength);
        return count;
    }
    static void bfs(List<List<Integer>> nodes, List<Integer> longestNode, boolean[] visited, int start){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];
            for(int n : nodes.get(node)){
                if(!visited[n]){
                    longestNode.add(distance + 1);
                    queue.offer(new int[]{n, distance + 1});
                    visited[n] = true;
                }
            }
        }
    }
}