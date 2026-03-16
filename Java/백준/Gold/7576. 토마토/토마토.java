import java.util.*;
import java.io.*;

public class Main {

    static int M, N;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int days = 0;

    static class Location {
        int x;
        int y;

        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        Queue<Location> queue = new LinkedList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    queue.offer(new Location(i, j));
                }
            }
        }

        bfs(queue);

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days - 1);
    }

    public static void bfs(Queue<Location> queue){
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Location cur = queue.poll();
                for(int d = 0; d < 4; d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx < 0 || ny < 0 || nx >= M || ny >= N){
                        continue;
                    }
                    if(map[nx][ny] == 0){
                        map[nx][ny] = 1;
                        queue.offer(new Location(nx, ny));
                    }
                }
            }
            days++;
        }
    }
}