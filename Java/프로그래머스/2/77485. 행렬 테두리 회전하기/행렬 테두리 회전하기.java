import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] numMap = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                numMap[i][j] = value++;
            }
        }
        
        List<Integer> minList = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            int startX = queries[i][0];
            int startY = queries[i][1];
            int endX = queries[i][2];
            int endY = queries[i][3];
            minList.add(rotate(numMap, startX, startY, endX, endY));
        }
        
        int[] answer = new int[minList.size()];
        for(int i = 0; i < minList.size(); i++){
            answer[i] = minList.get(i);
        }
        return answer;
    }
    
    static int rotate(int[][] map, int startX, int startY, int endX, int endY) {
        int min = Integer.MAX_VALUE;
        int x = startX - 1, y = startY - 1;  
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(map[x][y]);
        
        int dir = 0;
        int cx = x;
        int cy = y;
        
        while (true) {
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];
            
            if (nx < startX - 1 || nx > endX - 1 || ny < startY - 1 || ny > endY - 1) {
                dir++;
                continue;
            }
            
            int temp = map[nx][ny];
            map[nx][ny] = queue.poll();
            queue.offer(temp);
            min = Math.min(min, temp);
            
            cx = nx;
            cy = ny;
            
            if (cx == x && cy == y) {
                break;
            }
        }
        return min;
    }
}
