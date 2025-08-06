import java.util.*;
class Solution {
    static int INF = 2000000;
    public int solution(int N, int[][] road, int K) {
        
        int[][] dist = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        for(int[] path : road){
            int u = path[0];
            int v = path[1];
            int cost = path[2];
            dist[u][v] = Math.min(dist[u][v], cost);
            dist[v][u] = Math.min(dist[v][u], cost);
        }
        
        
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int answer = 1;
        for(int k = 2; k <= N; k++){
            if(dist[1][k] <= K){
                answer++;
            }
        }
        return answer;
    }
}