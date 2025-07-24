import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<HashSet<Integer>> nodes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            nodes.add(new HashSet<>());
        }
        boolean[] visited = new boolean[n];
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                int node = i;
                int connected = j;
                if(computers[i][j] == 1 && i != j){
                    nodes.get(i).add(j);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                isConnected(i, nodes, visited);
                answer++;
            }
        }
        return answer;
    }
    static void isConnected(int node, List<HashSet<Integer>> nodes, boolean[] visited){
        visited[node] = true;
        for(int next : nodes.get(node)){
            if(!visited[next]){
                isConnected(next, nodes, visited);
            }
        }
    }
}