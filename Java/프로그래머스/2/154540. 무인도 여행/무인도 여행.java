import java.util.*;
class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public int[] solution(String[] maps) {
           int row = maps.length;
           int col = maps[0].length();
           char[][] map = new char[row][col];

           for (int i = 0; i < row; i++) {
                map[i] = maps[i].toCharArray();
           }
           boolean[][] visited = new boolean[row][col]; 
           List<Integer> list = new ArrayList<>();
           int sum = 0;
           for(int i = 0; i < row; i++){
               for(int j = 0; j < col; j++){
                   sum = 0;
                   if(visited[i][j] == true || map[i][j] == 'X'){
                       continue;
                   }
                   else{
                       sum = bfs(i, j, visited, map);
                       list.add(sum);
                       
                   }
               }
           }
    
        if (list.isEmpty()) return new int[]{-1};
        Collections.sort(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
    static int bfs(int x, int y, boolean[][] visited, char[][] map){
        Queue<int[]> queue = new LinkedList<>();
        int row = map.length;
        int col = map[0].length;
        queue.add(new int[]{x, y});
        int sum = map[x][y] - '0';
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            visited[currentX][currentY] = true;
            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && map[nextX][nextY] != 'X'){
                   if(!visited[nextX][nextY]){
                       sum += map[nextX][nextY] - '0';
                       queue.add(new int[]{nextX, nextY});
                       visited[nextX][nextY] = true;
                   }
                }
            }
        }
      return sum;   
    }
}