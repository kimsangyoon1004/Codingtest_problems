import java.util.*;
class Solution {
    static int INF = 2000000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] distance = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }
        for(int[] fare : fares){
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];
            distance[u][v] = cost;
            distance[v][u] = cost;
        }
        // Floyd
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        answer = INF;
        for(int k = 1; k <= n; k++){
            answer = Math.min(answer, distance[s][k] + distance[k][a] + distance[k][b]);
        }
        return answer;
    }
}