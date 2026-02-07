import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;
    static int N = 0;
    static boolean[][] visited;
    static char[][] map;
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String row = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = row.charAt(j);
            }
        } 
        List<Integer> numList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == '1'){
                    numList.add(bfs(i, j));
                    count++;
                }
            }
        }
        Collections.sort(numList);
        System.out.println(count);
        for(int n : numList){
            System.out.println(n);
        }
        
    }
    static int bfs(int startX, int startY){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;
        int sumNums = 1;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int currentX = node.x;
            int currentY = node.y;
            
            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N){
                    if(map[nextX][nextY] == '1' && !visited[nextX][nextY]){
                        queue.add(new Node(nextX, nextY));
                        visited[nextX][nextY] = true;
                        sumNums++;
                    }
                }
            }
        }
        return sumNums;
    }
}